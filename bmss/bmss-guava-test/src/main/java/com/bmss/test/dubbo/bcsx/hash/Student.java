package com.bmss.test.dubbo.bcsx.hash;

import com.google.common.collect.Sets;

import java.util.HashSet;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class Student {

    private int age;

    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Student s1 = new Student(10, "zhangsan");
        Student s2 = new Student(10, "zhangsan");
        System.out.println("s1 == s2" + (s1 == s2));
        System.out.println("s1.equal(s2)" + (s1.equals(s2)));
        HashSet<Student> students = Sets.newHashSet(s1, s2);
        System.out.println("set size: " + students.size());
    }


}
