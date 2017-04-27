package com.bmss.test.result;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/3/24.
 */
public class WebResult {

    private final static String SUCCESS_CODE = "000000";

    private final static String SUCCESS_MSG = "success";

    public static WebResult SUCCESS = new WebResult(SUCCESS_CODE, SUCCESS_MSG);

    private String code;

    private String msg;

    private Object data;


    public WebResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public WebResult() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    public WebResult(List<WebResult> webResults){
        boolean error = true;
        String message = null;
        for(WebResult webResult : webResults){
            if(!webResult.getCode().equals("000000")){
                error = false;
                if(message != null){
                    message = message + ", " + webResult.getMsg();
                }else {
                    message = webResult.getMsg();
                }
            }
        }
        if(error){
            this.code = SUCCESS_CODE;
            this.msg = SUCCESS_MSG;
        }else {
            this.code = "000001";
            this.msg = message;
        }
    }

}
