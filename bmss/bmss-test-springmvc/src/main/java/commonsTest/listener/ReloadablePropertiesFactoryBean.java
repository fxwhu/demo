package commonsTest.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by fengxuan1 on 2016/12/12.
 */
public class ReloadablePropertiesFactoryBean extends PropertiesFactoryBean implements ApplicationContextAware{


    private static ApplicationContext applicationContext;

    private List<IReloadablePropertiesListener> listeners;

    private Resource[] locations;

    private long[] lastModified;

    private ReloadablePropertiesBase reloadablePropertiesBase;

    public void setListeners(List<IReloadablePropertiesListener> listenerList) {
        this.listeners = new ArrayList<>();
        for(IReloadablePropertiesListener o: listenerList){
            listeners.add(o);
        }
    }

    @Override
    protected Properties createProperties() throws IOException {
        return (Properties)createMyInstance();
    }


    protected Object createMyInstance() throws IOException{
        if(!isSingleton()){
            throw new RuntimeException("======");
        }

        reloadablePropertiesBase = new ReloadablePropertiesBaseImpl();

        if(listeners != null){
            reloadablePropertiesBase.setListeners(listeners);
        }
        reload(true);

        ReloadConfigurationMonitor.addReconfigurableBean((ReconfigableBean)reloadablePropertiesBase);

        return reloadablePropertiesBase;
    }

    protected void reload(final Boolean forceReload) throws IOException{
        boolean reload = forceReload;
        for (int i = 0; i <locations.length; i++) {
            Resource resource = locations[i];

            File file;
            try {
                file = resource.getFile();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                long l = file.lastModified();

                if(l > lastModified[i]){
                    lastModified[i] = l;
                    reload = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(reload){
            doReload();
        }
    }

    private void doReload() throws IOException{
        reloadablePropertiesBase.setInternalProperties(mergeProperties());
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    class ReloadablePropertiesBaseImpl extends ReloadablePropertiesBase implements ReconfigableBean{

        @Override
        public void reloadConfiguration() throws Exception {
            ReloadablePropertiesFactoryBean.this.reload(false);
        }
    }
}
