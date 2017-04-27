package com.bmss.properties;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.*;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.*;

/**
 * Created by fengxuan1 on 2017/4/18.
 */
public class MyProperties extends PropertyPlaceholderConfigurer {


    private String currentPropertyName, currentBeanName, beanName, propertiesKey;

    private BeanFactory beanFactory;

    //缓存properties中key对应的bean的相关信息
    private Map<String, BeanNameAndValue> keyAndBean = Maps.newConcurrentMap();


    public Map<String, BeanNameAndValue> getKeyAndBean() {
        return keyAndBean;
    }

    public void init(String path){
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties(path);
            Set<String> strings = properties.stringPropertyNames();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        BeanDefinitionVisitor visitor = new PlaceholderResolvingBeanDefinitionVisitor(props);
        String[] beanNames = beanFactoryToProcess.getBeanDefinitionNames();
        for (String curName : beanNames) {
            // Check that we're not parsing our own bean definition,
            // to avoid failing on unresolvable placeholders in properties file locations.
            if (!(curName.equals(this.beanName) && beanFactoryToProcess.equals(this.beanFactory))) {
                this.currentBeanName = curName;
                try {
                    BeanDefinition bd = beanFactoryToProcess.getBeanDefinition(curName);
                    try {
                        visitor.visitBeanDefinition(bd);
                    }
                    catch (Exception ex) {
                        throw new BeanDefinitionStoreException(bd.getResourceDescription(), curName, ex.getMessage(), ex);
                    }
                } finally {
                    currentBeanName = null;
                }
            }
        }
    }


    /**
     * 对于被标记为动态的，进行 构造 property dependency 非动态的，则由原来的spring进行处理
     *
     * @param strVal
     * @param props
     * @param visitedPlaceholders
     *
     * @return
     *
     * @throws BeanDefinitionStoreException
     */
    protected String parseStringValue(String strVal, Properties props, Set visitedPlaceholders) throws BeanDefinitionStoreException {

        if(strVal != null && !"".equals(strVal)){
            if(strVal.startsWith("${") && strVal.endsWith("}")){
                propertiesKey = strVal.replace("${", "").replace("}", "");
                keyAndBean.put(propertiesKey, new BeanNameAndValue(currentBeanName, currentPropertyName));
                propertiesKey = null;
            }
        }


        /*DynamicProperty dynamic = null;

        // replace reloading prefix and suffix by "normal" prefix and suffix.
        // remember all the "dynamic" placeholders encountered.
        StringBuffer buf = new StringBuffer(strVal);
        int startIndex = strVal.indexOf(this.placeholderPrefix);
        while (startIndex != -1) {
            int endIndex = buf.toString().indexOf(this.placeholderSuffix, startIndex + this.placeholderPrefix.length());
            if (endIndex != -1) {
                if (currentBeanName != null && currentPropertyName != null) {
                    String placeholder = buf.substring(startIndex + this.placeholderPrefix.length(), endIndex);
                    placeholder = getPlaceholder(placeholder);
                    if (dynamic == null) {
                        dynamic = getDynamic(currentBeanName, currentPropertyName, strVal);
                    }
                    addDependency(dynamic, placeholder);
                } else {
                    logger.warn("dynamic property outside bean property value - ignored: " + strVal);
                }
                startIndex = endIndex - this.placeholderPrefix.length() + this.placeholderPrefix.length() + this.placeholderSuffix.length();
                startIndex = strVal.indexOf(this.placeholderPrefix, startIndex);
            } else {
                startIndex = -1;
            }
        }*/
        // then, business as usual. no recursive reloading placeholders please.
        return super.parseStringValue(strVal, props, visitedPlaceholders);
    }

    public void changeProperties(){

    }


    /**
     * 替换掉spring的 config resolver，这样我们才可以解析掉自己的config
     */
    private class PlaceholderResolvingBeanDefinitionVisitor extends BeanDefinitionVisitor {

        private final Properties props;

        public PlaceholderResolvingBeanDefinitionVisitor(Properties props) {
            this.props = props;
        }

        protected void visitPropertyValues(MutablePropertyValues pvs) {
            PropertyValue[] pvArray = pvs.getPropertyValues();
            for (PropertyValue pv : pvArray) {
                currentPropertyName = pv.getName();
                try {
                    Object newVal = resolveValue(pv.getValue());
                    if (!ObjectUtils.nullSafeEquals(newVal, pv.getValue())) {
                        pvs.addPropertyValue(pv.getName(), newVal);
                    }
                } finally {
                    currentPropertyName = null;
                }
            }
        }

        protected void visitIndexedArgumentValues(Map<Integer, ConstructorArgumentValues.ValueHolder> ias) {
            for (ConstructorArgumentValues.ValueHolder valueHolder : ias.values()) {
                try {
                    currentPropertyName = valueHolder.getName();
                    Object newVal = resolveValue(valueHolder.getValue());
                    if (!ObjectUtils.nullSafeEquals(newVal, valueHolder.getValue())) {
                        valueHolder.setValue(newVal);
                    }
                } finally {
                    currentPropertyName = null;
                }

            }
        }

        protected void visitGenericArgumentValues(List<ConstructorArgumentValues.ValueHolder> gas) {
            for (ConstructorArgumentValues.ValueHolder valueHolder : gas) {
                try {
                    currentPropertyName = valueHolder.getName();
                    Object newVal = resolveValue(valueHolder.getValue());
                    if (!ObjectUtils.nullSafeEquals(newVal, valueHolder.getValue())) {
                        valueHolder.setValue(newVal);
                    }

                } finally {
                    currentPropertyName = null;
                }

            }
        }

        protected String resolveStringValue(String strVal) throws BeansException {
            return parseStringValue(strVal, this.props, new HashSet());
        }
    }


    //保存beanName，bean属性
    class BeanNameAndValue{
        String beanName;
        String beanProperty;

        public BeanNameAndValue(String beanName, String beanProperty) {
            this.beanName = beanName;
            this.beanProperty = beanProperty;
        }

        public String getBeanName() {
            return beanName;
        }

        public void setBeanName(String beanName) {
            this.beanName = beanName;
        }

        public String getBeanProperty() {
            return beanProperty;
        }

        public void setBeanProperty(String beanProperty) {
            this.beanProperty = beanProperty;
        }
    }
}
