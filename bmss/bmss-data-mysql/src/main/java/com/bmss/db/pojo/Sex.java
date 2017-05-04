package com.bmss.db.pojo;

/**
 * Created by fengxuan1 on 2017/5/4.
 */
public enum Sex {
    male(1, "男"), female(2, "女");

    Sex(int id, String name) {
        this.id = id;
        this.value = name;
    }

    private int id;
    private String value;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Sex getSexByKey(int key){
        for(Sex sex : Sex.values()){
            if(sex.id == key){
                return sex;
            }
        }
        return null;
    }

    public static Sex getSexByValue(String value){
        for(Sex sex : Sex.values()){
            if(sex.value == value){
                return sex;
            }
        }
        return null;
    }

    public static Sex getSexByName(String name){
        for(Sex sex : Sex.values()){
            if(sex.name() == name){
                return sex;
            }
        }
        return null;
    }
}
