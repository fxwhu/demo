package com.bmss.session.multipleSession;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
public class Account {
    private String username;

    private String logoutUrl;

    private String switchAccountUrl;

    public Account(String username, String logoutUrl, String switchAccountUrl) {
        super();
        this.username = username;
        this.logoutUrl = logoutUrl;
        this.switchAccountUrl = switchAccountUrl;
    }

    public String getUsername() {
        return this.username;
    }

    public String getLogoutUrl() {
        return this.logoutUrl;
    }

    public String getSwitchAccountUrl() {
        return this.switchAccountUrl;
    }
}
