package com.bmss.test;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jConfig {
    private boolean reload = true;
    private int interval = 60000;
    private static final Logger logger = LoggerFactory.getLogger(Log4jConfig.class);

    /**
     * log4j日志自动加载
     *
     * @param reload   是否开启自动加载
     * @param interval 自动加载时间(ms)
     */
    public Log4jConfig(boolean reload, int interval) {
        this.reload = reload;
        this.interval = interval;
        this.loadConfig();
    }

    public void loadConfig() {
        String log4jPath = Log4jConfig.class.getClassLoader().getResource("log4j.properties").getPath();
        logger.debug("log4j file path: " + log4jPath);

        // 间隔特定时间，检测文件是否修改，自动重新读取配置
        PropertyConfigurator.configureAndWatch(log4jPath, this.interval);
    }

    public static void main(String[] args) {
        String log4jPath = Log4jConfig.class.getClassLoader().getResource("log4j.properties").getPath();
        System.out.println(log4jPath);
    }
}
