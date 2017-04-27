package com.bmss.test.springmvc.util;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;

import static com.bmss.test.springmvc.commons.DataEnum.MASTER;
import static com.bmss.test.springmvc.commons.DataEnum.SALVE;

/**
 * Created by fengxuan1 on 2016/12/30.
 */
public class DataSourceAspect {

    private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
    public static Map<Method,String> dateSourceMap = Maps.newConcurrentMap();
    private static Method tmpMethod;
    private static String dataSourceString;



    public void before(JoinPoint point)
    {
        Object target = point.getTarget();
        String method = point.getSignature().getName();

        Class<?>[] classz = target.getClass().getInterfaces();

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            tmpMethod = m;
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                dataSourceString = m.getAnnotation(DataSource.class).value().getMessage();
                logger.info(dataSourceString);
                if(DynamicDataSourceHolder.getDataSouce() == null){
                    DynamicDataSourceHolder.putDataSource(m.getAnnotation(DataSource.class).value().getMessage());
//                    dateSourceMap.put(m, m.getAnnotation(DataSource.class).value().getMessage());
                }
            }else {
                if(DynamicDataSourceHolder.getDataSouce() == null){
                    logger.info("default datasource: master");
                    DynamicDataSourceHolder.putDataSource(MASTER.getMessage());
                }
//                dateSourceMap.put(m, DataEnum.MASTER.getMessage());
            }

        } catch (Exception e) {
//            logger.error("error",e.fillInStackTrace());
            logger.error("before into method error!");
        }
    }


    public static String getDataSource(){
        logger.info("================" + dateSourceMap.get(tmpMethod));
        return dateSourceMap.get(tmpMethod);
    }


    public void handleException(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        logger.info("==================" + point.getSignature().getName());
        logger.info(JSON.toJSONString(args));

        /*Object target = point.getTarget();
        String method = point.getSignature().getName();

        Class<?>[] classz = target.getClass().getInterfaces();

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();
        Method m = classz[0].getMethod(method, parameterTypes);*/
        try {
            point.proceed(args);
        } catch (Exception e) {
            logger.info("errror");
            if(dataSourceString == MASTER.getMessage() || dataSourceString == null){
                DynamicDataSourceHolder.remove();
                DynamicDataSourceHolder.putDataSource(SALVE.getMessage());
//                dateSourceMap.put(m, DataEnum.SALVE.getMessage());
            }else {
                DynamicDataSourceHolder.putDataSource(MASTER.getMessage());
//                dateSourceMap.put(m, DataEnum.MASTER.getMessage());
            }
    }
}


    public static void main(String[] args) {
        try {
            Integer.parseInt("a");
        } catch (NumberFormatException e) {
            logger.error("error",e.fillInStackTrace());
        }
    }
}
