package com.bmss.test.exception;

/**
 * Created by fengxuan1 on 2017/3/27.
 */
public class WebException extends Exception {

    String code;

    String msg;


    public WebException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public WebException(Throwable cause, String code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
