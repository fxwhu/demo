package com.bmss.test.dubbo.degsignModel.Observer;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class WatcherA implements Watcher {
    @Override
    public void getMessageFormWatched(String s) {
        System.out.println("A watch the watched change" + s);
    }
}
