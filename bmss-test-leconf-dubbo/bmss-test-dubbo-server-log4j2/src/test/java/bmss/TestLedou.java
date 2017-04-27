package bmss;

import com.alibaba.fastjson.JSON;
import com.lenovo.ledou.web.client.LedouServiceClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by fengxuan1 on 2017/3/2.
 */
public class TestLedou {

    public static void main(String[] args) {
        LedouServiceClient instance = LedouServiceClient.getInstance();
        Map<String, Object> logsMap = new HashMap<>();
        logsMap.put("bask_work_order", 7023531);
        String detail = JSON.toJSONString(logsMap);
        Future<String> ldto = instance.getLedouService().write("LDTO", "10063557118", 2199L, 2, detail);
        try {
            System.out.println(ldto.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
