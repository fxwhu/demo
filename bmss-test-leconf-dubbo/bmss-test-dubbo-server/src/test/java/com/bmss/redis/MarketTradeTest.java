package com.bmss.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/3/13.
 */
public class MarketTradeTest {
    ClassPathXmlApplicationContext context;
    MarketTrade marketTrade;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        marketTrade = context.getBean(MarketTrade.class);
    }


    @Test
    public void sell() throws Exception {
        marketTrade.sell("1", "ItemB", 5.60);
    }

    @Test
    public void buy() throws Exception {
        marketTrade.buy("1", "2", "ItemB");
    }

    @Test
    public void createUserAccount() throws Exception {
        User user = new User("1", "jack", 10.00);
        marketTrade.createUserAccount(user);
        User user1 = new User("2", "tom", 10.00);
        marketTrade.createUserAccount(user1);
    }

    @Test
    public void createInventory() throws Exception {
        marketTrade.createInventory("1", "ItemA");
        marketTrade.createInventory("1", "ItemB");
    }

}