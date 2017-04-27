package com.bmss.test.guava.collection;

import com.google.common.base.Predicate;
import com.google.common.collect.*;
import com.google.common.math.IntMath;
import org.junit.Before;
import org.junit.Test;

import java.math.RoundingMode;
import java.util.*;

/**
 * Created by fengxuan1 on 2016/11/12.
 * multiset ==== Map<Object, Integer>
 * multiMap ===== Map<Object, List<Object>>
 * table
 * sets  ====交，差，不同
 * (im)mutable(map,set,list)
 * FluentIterable
 *
 */
public class TestNew {
    ArrayList<Person> persons;

    /**
     * test immutableList Map  主要的方法有ImmutableList.of 或者通过 builder
     */
    @Test
    public void testNewList() {
        ArrayList<String> list1 = Lists.newArrayList("1", "2", "3");
        Maps.newConcurrentMap();
        ImmutableList<String> list2 = ImmutableList.of("1", "2", "3");
        List<String> s2 = new ArrayList<String>(list2);
        s2.add("4");
        System.out.println(s2);


        ImmutableList.Builder<Object> builder = ImmutableList.builder();
        builder.add("1", "2", "3");
        builder.add("4");
        ImmutableList<Object> imlist = builder.build();
        System.out.println(imlist);
    }

    @Test

    public void testMapMake() {


    }

    @Before
    public void setUp() {
        Person p1 = new Person(10, "a");
        Person p2 = new Person(8, "b");
        Person p3 = new Person(15, "c");
        Person p4 = new Person(13, "d");
        persons = Lists.newArrayList(p1, p2, p3, p4);
    }

    @Test
    /**
     *测试过滤
     */
    public void testFluentIerable(){
        FluentIterable<Person> personFilterByAge = FluentIterable.from(persons).filter(new Predicate<Person>() {
            public boolean apply(Person person) {
                return person.getAge() > 10;
            }
        });
        ImmutableList<Person> newpersons = personFilterByAge.toList();
        System.out.println(newpersons + "====" + persons);

    }


    /**
     *本测试单元测试multiset的功能，此类类似于Map<Object, Integer>操作方便
     */
    @Test
    public void testMulti() {
        HashMultiset<Object> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("a");
        multiset.add("c");
        multiset.add("b");
        multiset.add("aa");
        multiset.add("a");

//        multiset.setCount("a", 0);//可以设置map的key值的大小

        int size = multiset.size();
        int asize = multiset.count("a");

        Set<Multiset.Entry<Object>> entries = multiset.entrySet();//返回一个视图[b x 2, c, a x 3, aa]
        Set<Object> set = multiset.elementSet();//相当于获取map的key
        int mapsize = set.size();//相当于获取map的size


        Iterator<Object> iterator = multiset.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println(size + "===" + asize + "====" + entries + "===" + set);


        TreeMultiset treeMultiset = TreeMultiset.create();
    }



    @Test
    public void testSets(){
        String s = "1,2,3,5";
        String s1 = "2,3,4,9";
        ArrayList<String> list1 = Lists.newArrayList(s.split(","));
        ArrayList<String> list2 = Lists.newArrayList(s1.split(","));

        HashSet<String> set1 = Sets.newHashSet(list1);
        HashSet<String> set2 = Sets.newHashSet(list2);

        Sets.SetView<String> difference = Sets.difference(set1, set2);//will return 1,5
        Sets.SetView<String> symmetricDifference = Sets.symmetricDifference(set1, set2);//will return 1,5,4,9
        Sets.SetView<String> intersection = Sets.intersection(set1, set2);//will return 2,3
        Sets.SetView<String> union = Sets.union(set1, set2);//will return 1,2,3,4,5,9

        System.out.println(difference + "=" + symmetricDifference + "===" + intersection + "==" +
          union
        );
    }


    @Test
    /**
     *测试multimap 可以方便的实现Map<Object,List<Object>>
     *
     * BiMap特用于反转key和value
     */
    public void testMultiMap(){
        ArrayListMultimap<Object, Object> map = ArrayListMultimap.create();
        map.put("a", "hello");
        map.put("a", "hello1");
        map.put("b", "hello");
        map.put("b", "hello1");
        map.put("b", "hello2");
        Multiset<Object> keys = map.keys();

        Set<Object> objects = map.keySet();

        System.out.println(map.size());

        Collection<Object> values = map.values();//返回单个的collection与map.asMap.values()不同

        Map<Object, Collection<Object>> objectCollectionMap = map.asMap();

        Collection<Collection<Object>> values1 = objectCollectionMap.values();
//        ArrayList<Object> hello4 = Lists.newArrayList((Object)("hello4"));
//        objectCollectionMap.put("a", hello4);//put会报错
        Set<Multiset.Entry<Object>> entries = keys.entrySet();
        System.out.println(entries + "===" + keys + "====" + objects
                + "====" + values + "====" + values1 + "====" + objectCollectionMap);

        HashBiMap<String, String> oldemap = HashBiMap.create();
        oldemap.put("a", "hello1");
        BiMap<String, String> newmap = oldemap.inverse();
        System.out.println(oldemap + "====" + newmap);
    }


    @Test
    public void testTable() {
        HashBasedTable<Integer, Integer, String> table = HashBasedTable.create();
        for(int i = 0; i <= 9; i ++){
            for (int j = 0; j <= i ; j++) {
                table.put(i, j, String.valueOf(i*j));
            }
        }
//        Set<Table.Cell<Integer, Integer, String>> cells = table.cellSet();
//        System.out.println(cells);
//        for(Table.Cell item :cells){
//            System.out.println(item);
//        }

        Map<Integer, Map<Integer, String>> integerMapMap = table.rowMap();
        for(Map.Entry item :integerMapMap.entrySet()){
//            System.out.println(item.getKey() + ": " + item.getValue().toString().replaceAll("=",": "));
        }

        Map<String, Object> hashmap = Maps.newHashMap();
        hashmap.put("name", "test");
        hashmap.put("age", 10);
        Person person = new Person(10, "xiao");
        MutableClassToInstanceMap<Object> mutableMap = MutableClassToInstanceMap.create();
        mutableMap.putInstance(Person.class, person);
        System.out.println(mutableMap);
    }


    @Test
    public void TestMapMaker(){
        ArrayList<Integer> intlist = Lists.newArrayList(10, 11, 12);
        Collection<Integer> newList = Collections2.filter(intlist, new Predicate<Integer>() {
            public boolean apply(Integer integer) {
                return integer > 11;
            }
        });
        System.out.println(newList);

    }


    @Test
    public void testInMath() {
        int checkedPow1 = IntMath.checkedPow(3, 4);
        int factorial = IntMath.factorial(5);
        int gcd = IntMath.gcd(12, 8);
        int sqrt = IntMath.sqrt(10, RoundingMode.HALF_UP);
        System.out.println(checkedPow1 + "========" + factorial + "===" + gcd + "====" + sqrt);

//        System.out.println(IntMath.binomial(9, 3));//二次项系数
    }



    @Test
    public void testOrdering() {
        ArrayList<Integer> intList = Lists.newArrayList(2, 9, 10, 15, 23, 8, 6, 5, 9);
//        Ordering<Object> ordering1 = Ordering.allEqual();
//        Collections.sort(intList, ordering1);
//        System.out.println(intList);
        Ordering<Comparable> natural = Ordering.natural();
        List<Integer> integers = natural.greatestOf(intList, 3);
        List<Integer> integers2 = natural.leastOf(intList, 3);

        List<Integer> newintList = natural.sortedCopy(intList);
        System.out.println(integers + "====" + integers2 + "=====" + newintList + "====" + intList);
    }

    @Test
    public void testMap(){
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("a", 1, "b", 3, "d", 5);
        MapDifference<String, Integer> diff = Maps.difference(left, right);
        Map<String, Integer> map1 = diff.entriesInCommon();
        Map<String, MapDifference.ValueDifference<Integer>> map2 = diff.entriesDiffering();
        Map<String, Integer> map3 = diff.entriesOnlyOnLeft();
        Map<String, Integer> map4 = diff.entriesOnlyOnRight();
        System.out.println(map1 + "===" + map2 + "====" + map3 + "====" + map4);

    }
}


class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}