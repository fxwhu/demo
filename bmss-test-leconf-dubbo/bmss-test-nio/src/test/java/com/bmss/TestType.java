package com.bmss;

import com.bmss.test.nio.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by fengxuan1 on 2017/3/23.
 */
public class TestType {

    public static void main(String[] args) {
        People people = new People();
        Field[] fields = people.getClass().getDeclaredFields();
        for(Field field: fields){
            String type = field.getType().getName();
            String name = field.getName();
//            if(type.equals("int")){
//                System.out.println("name: " + name + " is " + "int");
//            }
//            if(type.equals("String")){
//                System.out.println("name: " + name + " is " + "String");
//            }
            System.out.println("name: " + name + " is " + type);
        }

        ReflectionUtils.setFieldValue(people, "name", "fengxuan");

        System.out.println(ReflectionUtils.getFieldValue(people, "name"));

    }


    private static class People{
        int age, money;
        String name;

       /* public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }*/
    }
}
