package commonsTest.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by fengxuan1 on 2016/12/12.
 */
public class ReloadConfigurationMonitor extends TimerTask {
    private static List<ReconfigableBean> reconfigableBeans = new ArrayList<>();

    public static void addReconfigurableBean(ReconfigableBean reconfigableBean){
        reconfigableBeans.add(reconfigableBean);
    }

    @Override
    public void run() {
        reload();
    }

    public static void reload(){
        for(ReconfigableBean reconfigableBean : reconfigableBeans){
            try {
                reconfigableBean.reloadConfiguration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
