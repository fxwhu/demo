package com.bmss.test.guava.collection;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Doubles;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.google.common.collect.Ordering.from;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class OrderingTest {

    final ArrayList<Integer> integers = Lists.newArrayList(null, 3, 4, 9, 10, 20);

    //arbitrary() 返回一个任意顺序对所有对象，其中compare(a, b) == 0 意味着a == b（身份平等）
    //usingToString() 返回由它们的字符串表示的自然顺序，toString()比较对象进行排序。
    //explicit() 返回根据它们出现的定列表中的顺序比较对象进行排序。
    //greatestOf(Iterable<E> iterable, int k) 返回从给定的迭代器按照这个顺序，从最大到最小k个最大的元素。
    @Test
    public void tetsOrdering() {
        List<Integer> result1 = Ordering.arbitrary().sortedCopy(integers);

        System.out.println("result1:" + result1);

        List<Integer> result2 = from(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                o1 = Optional.fromNullable(o1).or(0);
                o2 = Optional.fromNullable(o2).or(0);
                return Doubles.compare(o1, o2);
            }
        }).sortedCopy(integers);

        System.out.println("result2:" + result2);

        final ArrayList<Integer> integers1 = Lists.newArrayList(20, 1, 10, 30);

        final ArrayList<Integer> integers2 = Lists.newArrayList(20, 30, 1, 10);

        List<Integer> result3 = Ordering.explicit(integers1).sortedCopy(integers2);

        System.out.println("result3:" + result3);

        List<Integer> result4 = from(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                o1 = Optional.fromNullable(o1).or(0);
                o2 = Optional.fromNullable(o2).or(0);
                return Doubles.compare(o1, o2);
            }
        }).greatestOf(integers, 3);

        System.out.println("result4:" + result4);
    }

    @Test
    public void testOrdering2(){
        Integer max = from(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                o1 = Optional.fromNullable(o1).or(0);
                o2 = Optional.fromNullable(o2).or(0);
                return Doubles.compare(o1, o2);
            }
        }).max(integers);

        System.out.println("max:" + max);
    }


    @Test
    public void testBean(){
        List<Person> persons = from(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                o1 = (Person) Optional.fromNullable(o1).or(new Person("", 0));
                o2 = (Person) Optional.fromNullable(o2).or(new Person("", 0));
                if(Doubles.compare(o1.getAge(), o2.getAge()) != 0){
                    return Doubles.compare(o1.getAge(), o2.getAge());
                }
                return o1.getName().compareTo(o2.getName());
            }
        }).sortedCopy(Lists.<Person>newArrayList(new Person("xiaoming", 10), null,
                new Person("hong", 9), new Person("feng", 10)));

        System.out.println(JSON.toJSONString(persons));
    }


    //onResultOf(Function<F,? extends T> function) 返回一个新的排序在F上，首先应用功能给它们，然后比较使用此这些结果的顺序元素。
    @Test
    public void testBean2(){
        List<Person> persons = Ordering.from(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }).onResultOf(new Function<Person, String>() {
            @Override
            public String apply(Person input) {
                if(input == null){
                    return "";
                }
                return input.getName();
            }
        }).sortedCopy(Lists.<Person>newArrayList(new Person("xiaoming", 10), null,
        new Person("hong", 9), new Person("feng", 10)));

        System.out.println(JSON.toJSONString(persons));
    }


    static class Person{
        String name;
        int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
