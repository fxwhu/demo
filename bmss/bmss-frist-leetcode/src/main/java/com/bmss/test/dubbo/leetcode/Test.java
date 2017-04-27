package com.bmss.test.dubbo.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by fengxuan1 on 2016/10/18.
 */
public class Test {

    public static void main(String[] args) {
        Student a = null;
        Student b = new Student("xiaoming");
        a = b;
        for(int i = 0; i < 6; i ++) {
            b.next = new Student(String.valueOf(i));
            b = b.next;
        }
        a.print();
        b.print();
    }
}


class Student{
    String name;
    int age;
    List<String> classes;
    Student next;


    public Student(String name) {
        this.name = name;
    }

    public void print(){
        Student clone = this;
        while(clone != null){
            System.out.println(clone.name);
            clone = clone.next;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", classes=" + JSON.toJSONString(classes) +
                '}';
    }
}
