package com.bmss.LocalThreadDemos;

/**
 * Created by fengxuan1 on 2017/1/17.
 */
public class InheritableThreadLocalTest extends InheritableThreadLocal {

    @Override
    protected Object initialValue() {
        return "30";
    }
}
