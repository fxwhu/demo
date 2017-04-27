package com;

import com.alibaba.fastjson.JSON;
import com.lenovo.ledou.web.client.LedouServiceClient;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by fengxuan1 on 2017/3/14.
 */
public class TestLedou {

    public static void main(String[] args) {
        try {
            LedouServiceClient ledouServiceClient = LedouServiceClient.getInstance();
            Future<String> read = ledouServiceClient.getLedouService().read("10085336130");
            Map<String, String> map = new HashMap<String, String>();
            map.put("bask_work_order", UUID.randomUUID().toString());
            String log = JSON.toJSONString(map);
            ledouServiceClient.getLedouService().write("LDTOR", "10085336130", 300L, 1, log, 1, 0);
            System.out.println("=========================");
            System.out.println("=======" + read.get());
            System.out.println("===============finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Throwable e){
            e.printStackTrace();
        }
    }

    @Test
    public void printTime() throws ParseException {
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-31").getTime());
        System.out.println(134741646-15580030);
        System.out.println(72190546-12657409);


    }
}
