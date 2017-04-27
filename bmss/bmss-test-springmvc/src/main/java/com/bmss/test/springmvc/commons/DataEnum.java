package com.bmss.test.springmvc.commons;

/**
 * Created by fengxuan1 on 2016/12/30.
 */
public enum DataEnum {
    MASTER("master"), SALVE("salve");

    DataEnum(String message){
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
