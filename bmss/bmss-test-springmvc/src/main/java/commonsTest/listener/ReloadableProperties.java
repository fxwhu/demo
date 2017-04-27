package commonsTest.listener;

import java.util.Properties;

/**
 * Created by fengxuan1 on 2016/12/12.
 */
public interface ReloadableProperties {
    Properties getProperties();

    void addReloadablePropertiesListener(IReloadablePropertiesListener listener);

    void removedReloadablePropertiesListener(IReloadablePropertiesListener listener);

}
