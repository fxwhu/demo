package com.bmss.redis;

/**
 * Created by fengxuan1 on 2017/3/13.
 */
public class User {

    private String id;

    private String name;

    private double funds;

    public User(String id, String name, double funds) {
        this.id = id;
        this.name = name;
        this.funds = funds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }
}
