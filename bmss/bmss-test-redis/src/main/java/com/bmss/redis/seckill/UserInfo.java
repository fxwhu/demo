package com.bmss.redis.seckill;

import java.io.Serializable;

/**
 * Created by fengxuan1 on 2017/4/11.
 */
public class UserInfo implements Serializable{

    private String userId;

    private long time;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
