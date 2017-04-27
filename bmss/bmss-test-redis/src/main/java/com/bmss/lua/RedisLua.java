package com.bmss.lua;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2017/4/21.
 */
@Component
public class RedisLua implements InitializingBean{
    @Autowired
    CacheSha1 cacheSha1;

    private String test_script;

    public void init(){
        this.test_script = cacheSha1.get(CacheKeyEnum.TEST);
    }

    public String limitIp(String ip) throws Exception {
//        String timeFormat = new SimpleDateFormat("HH-mm-ss").format(new Date());
//        String key = ip + "_" + timeFormat;
        return cacheSha1.evalsha(test_script, ip);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
