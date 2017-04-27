package com.bmss.xa;


/**
 * Created by fengxuan1 on 2017/4/14.
 */
public class Account {

    private String userId;

    private double money;

    private People people;

    public Account() {
    }

    public Account(String userId, double money) {
        this.userId = userId;
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }


}
