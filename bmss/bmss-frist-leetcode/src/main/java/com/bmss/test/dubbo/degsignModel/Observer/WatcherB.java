package com.bmss.test.dubbo.degsignModel.Observer;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class WatcherB implements Watcher {
    @Override
    public void getMessageFormWatched(String s) {
        System.out.println("B watch the watched change" + s);
    }
}
