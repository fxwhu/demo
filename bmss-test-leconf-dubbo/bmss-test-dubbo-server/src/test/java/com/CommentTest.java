package com;

import com.alibaba.fastjson.JSON;
import com.lenovo.comment.model.OrderMessage;
import org.lenovo.comment.client.OrderCommnetClient;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/10.
 */
public class CommentTest {

    public static void main(String[] args) {
        OrderCommnetClient orderCommnetClient = OrderCommnetClient.getInstance();

        List<OrderMessage> orderMessages = orderCommnetClient.getOrderMessageService().waitToValuate("111", null, "1", 1, 10);

        System.out.println(JSON.toJSONString(orderMessages));
    }
}
