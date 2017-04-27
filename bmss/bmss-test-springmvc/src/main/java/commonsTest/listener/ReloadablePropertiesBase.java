package commonsTest.listener;

import java.util.List;
import java.util.Properties;

/**
 * Created by fengxuan1 on 2016/12/12.
 */
public class ReloadablePropertiesBase implements ReloadableProperties {
    private List<IReloadablePropertiesListener> listeners;

    private Properties internalProperties;

    private Properties getDelegate(){
        synchronized (this){
            return internalProperties;
        }
    }

    public void setListeners(List<IReloadablePropertiesListener> listeners) {
        this.listeners = listeners;
    }

    public void setInternalProperties(Properties properties) {
        Properties oldProperties = internalProperties;
        synchronized (this){
            internalProperties = properties;
        }
        notifyChange(oldProperties);
    }

    @Override
    public Properties getProperties() {
        return getDelegate();
    }

    @Override
    public void addReloadablePropertiesListener(IReloadablePropertiesListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removedReloadablePropertiesListener(IReloadablePropertiesListener listener) {
        listeners.remove(listener);
    }


    protected void notifyChange(Properties oldProperties){
        PropertiesReloadEvent propertiesReloadEvent = new PropertiesReloadEvent(this, oldProperties);
        for(IReloadablePropertiesListener item : listeners){
            item.porpertiesReloaded(propertiesReloadEvent);
        }

    }
}
