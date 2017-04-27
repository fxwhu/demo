package com.bmss.test.guava.base;

import com.alibaba.fastjson.JSON;
import com.google.common.base.*;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class FluentIterableTest {



    final List<Person> persons =  Lists.newArrayList(new Person("ming", "male", 10),
            new Person("hong", "female", 12), new Person("feng", "male", 14));

    @Test
    public void testFunction(){
        ImmutableList<String> personStrings = FluentIterable.from(persons)
        .filter(new Predicate<Person>() {
            @Override
            public boolean apply(Person input) {
                if(input != null && input.getSex().endsWith("male")){
                    return true;
                }
                return false;
            }
        })
        .transform(new Function<Person, String>() {
            @Override
            public String apply(Person input) {
                return Joiner.on(",").join(input.getName(), input.getAge(), input.getSex());
            }
        })
        .toList();
//        .toSortedList(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        System.out.println(JSON.toJSONString(personStrings));


    }


    @Test
    public void testPredicates(){
        Predicate predicate1 = new Predicate<Person>() {
            @Override
            public boolean apply(Person input) {
                if(input != null && input.getAge() > 10)
                    return true;
                return false;
            }
        };
        Predicate predicate2 = new Predicate<Person>() {
            @Override
            public boolean apply(Person input) {
                if(input != null && input.getSex().endsWith("male"))
                    return true;
                return false;
            }
        };
        boolean apply = Predicates.and(predicate1, predicate2).apply(new Person("ming", "male", 10));
        boolean apply2 = Predicates.or(predicate1, predicate2).apply(new Person("ming", "male", 10));

        System.out.println("apply:" + apply + " ,apply2:" + apply2);

    }


    @Test
    public void testFunctions(){
        Function<List<Person>, String> function1 = new Function<List<Person>, String>() {
            @Override
            public String apply(List<Person> inputs) {
                StringBuilder result = new StringBuilder();
                for (Person person : inputs) {
                    result = Joiner.on(",").appendTo(result, person.getName(), person.getAge()).append(";");
                }
                System.out.println(result);
                return result.toString();
            }
        };
        Function<String, Map<String, String>> function2 = new Function<String, Map<String, String>>() {
            @Override
            public Map<String, String> apply(String input) {
                return Splitter.on(";").omitEmptyStrings().trimResults().withKeyValueSeparator(",").split(input);
            }
        };
        Map<String, String> apply = Functions.compose(function2, function1).apply(persons);
        System.out.println(apply);
    }


    class Person{
        String name, sex;
        int age;

        public Person(String name, String sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
