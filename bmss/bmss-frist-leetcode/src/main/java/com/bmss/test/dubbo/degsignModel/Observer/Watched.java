package com.bmss.test.dubbo.degsignModel.Observer;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public interface Watched {

    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatcher(String s);
}
