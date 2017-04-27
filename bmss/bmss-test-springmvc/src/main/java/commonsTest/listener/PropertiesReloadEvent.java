package commonsTest.listener;

import java.util.Properties;

/**
 * Created by fengxuan1 on 2016/12/12.
 */
public class PropertiesReloadEvent {

    final ReloadableProperties target;

    Properties oldProperties;

    public PropertiesReloadEvent(ReloadableProperties target, Properties oldProperties) {
        this.target = target;
        this.oldProperties = oldProperties;
    }

    public ReloadableProperties getTarget() {
        return target;
    }

    public Properties getOldProperties() {
        return oldProperties;
    }
}
