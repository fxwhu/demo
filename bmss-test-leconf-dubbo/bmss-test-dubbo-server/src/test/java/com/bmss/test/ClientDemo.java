package com.bmss.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2016/12/14.
 */
//@Component
public class ClientDemo {

    private static Logger logger = LoggerFactory.getLogger(ClientDemo.class);

//    @Value("#{configproperties_leconf['address']}")
    private String address;

//    @Value("#{configproperties_leconf['flag']}")
    private boolean flag;

    public String getAddress() {
        logger.info("info message");
        logger.debug("debugger message");
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        ClientDemo.logger = logger;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
