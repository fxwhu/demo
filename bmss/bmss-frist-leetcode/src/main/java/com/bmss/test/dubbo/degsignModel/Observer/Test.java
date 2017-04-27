package com.bmss.test.dubbo.degsignModel.Observer;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class Test {

    public static void main(String[] args) {
        Watched watched = new ConcertWatched();
        Watcher a = new WatcherA();
        Watcher b = new WatcherB();
        watched.addWatcher(a);
        watched.addWatcher(b);
        watched.notifyWatcher("watche say i am changing");
    }
}
