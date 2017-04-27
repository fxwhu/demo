package com.bmss.test;

import com.lenovo.leconf.client.common.update.ILeconfUpdatePipeline;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/12/27.
 */
//@Component
public class LeconfMonitor implements ILeconfUpdatePipeline{
    private static Logger logger = LoggerFactory.getLogger(LeconfMonitor.class);

//    @Value("true")
    private boolean reload;

//    @Value("60000")
    private int interval;

    public LeconfMonitor(boolean reload, int interval) {
        this.reload = reload;
        this.interval = interval;
        String log4jPropertiesPath = null;
        String log4jXMLPath = null;
        URL resource = Log4jConfig.class.getClassLoader().getResource("log4j.properties");
        URL xmlresource = Log4jConfig.class.getClassLoader().getResource("log4j.xml");
        if(resource != null){
            log4jPropertiesPath = resource.getPath();
            PropertyConfigurator.configureAndWatch(log4jPropertiesPath, this.interval);
        }else if (xmlresource != null){
            log4jXMLPath = xmlresource.getPath();
            logger.info("log4j.xml rescan");
            DOMConfigurator.configureAndWatch(log4jXMLPath, this.interval);
        }
    }

    @Override
    public void reloadLeconfFile(String s, String s1) throws Exception {
        logger.info("s: " + s + "s1: " + s1);
        if(s1.equals("log4j.properties")){
            System.out.println("============");
        }
    }

    @Override
    public void reloadLeconfItem(String s, Object o) throws Exception {

    }

    @Override
    public void reloadLeconfFile(String s, String s1, List<String> list) {
        System.out.println("s: " + s + "s1: " + s1);
        logger.info("s: " + s + "s1: " + s1);
        if(s.equals("log4j.properties")){
            logger.info("log4j.properties rescan");
            loadConfig(s);
        }else if(s.equals("log4j.xml")){
            logger.info("log4j.xml rescan");
            loadConfig(s);
        }
    }

    public void loadConfig(String s) {
        String log4jPath = Log4jConfig.class.getClassLoader().getResource(s).getPath();
        logger.debug("log4j file path: " + log4jPath);

        // 间隔特定时间，检测文件是否修改，自动重新读取配置
        PropertyConfigurator.configureAndWatch(log4jPath, this.interval);
    }

    public static void main(String[] args) {
    }
}
