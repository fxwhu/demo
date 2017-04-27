package com.bmss.test.dubbo.bcsx.hash;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.TreeSet;

import static com.google.common.collect.Sets.newHashSet;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class Student1 implements Comparable{

    private int age;

    private String name;

    public Student1(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("hashcode: " + hashCode());
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

    public int compareTo(Object o) {
        Student1 student1 = (Student1) o;
        System.out.println(student1.toString() + "===" + this.toString());
        return this.toString().compareTo(student1.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student1 student1 = (Student1) o;

        if (age != student1.age) return false;
        return name.equals(student1.name);

    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        return result;
    }


    public static void main(String[] args) {
        Student1 s1 = new Student1(10, "zhangsan");
        Student1 s2 = new Student1(10, "zhangsan");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equal(s2): " + (s1.equals(s2)));
        HashSet<Student1> students = newHashSet(s1, s2);
        TreeSet<Student1> students2 = Sets.newTreeSet();
        students2.add(s1);
        students2.add(s2);
        System.out.println("set size: " + students.size());
        System.out.println("set2 size: " + students2.size());
    }
}
