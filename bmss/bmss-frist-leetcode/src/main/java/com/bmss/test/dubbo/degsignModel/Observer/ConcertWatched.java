package com.bmss.test.dubbo.degsignModel.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class ConcertWatched implements Watched {

    List<Watcher> list = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatcher(String s) {
        for (Watcher watcher : list){
            watcher.getMessageFormWatched(s);
        }
    }
}
