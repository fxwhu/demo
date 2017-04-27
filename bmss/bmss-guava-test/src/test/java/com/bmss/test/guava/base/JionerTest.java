package com.bmss.test.guava.base;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class JionerTest {


    private static final Joiner J = Joiner.on("-");



    // <Integer> needed to prevent warning :(
    private static final Iterable<Integer> ITERABLE_ = Arrays.<Integer>asList();
    private static final Iterable<Integer> ITERABLE_1 = Arrays.asList(1);
    private static final Iterable<Integer> ITERABLE_12 = Arrays.asList(1, 2);
    private static final Iterable<Integer> ITERABLE_123 = Arrays.asList(1, 2, 3);
    private static final Iterable<Integer> ITERABLE_NULL = Arrays.asList((Integer) null);
    private static final Iterable<Integer> ITERABLE_NULL_NULL
            = Arrays.asList((Integer) null, null);
    private static final Iterable<Integer> ITERABLE_NULL_1 = Arrays.asList(null, 1);
    private static final Iterable<Integer> ITERABLE_1_NULL = Arrays.asList(1, null);
    private static final Iterable<Integer> ITERABLE_1_NULL_2 = Arrays.asList(1, null, 2);
    private static final Iterable<Integer> ITERABLE_FOUR_NULLS
            = Arrays.asList((Integer) null, null, null, null);


    @Test
    public void testNoSpecialNullBehavior(){
        checkNoOutput(J, ITERABLE_);
    }



    private static void checkNoOutput(Joiner joiner, Iterable<Integer> set) {
//        assertEquals("", joiner.join(set));
//        assertEquals("", joiner.join(set.iterator()));

        Object[] array = Lists.newArrayList(set).toArray(new Integer[0]);
//        assertEquals("", joiner.join(array));

        StringBuilder sb1FromIterable = new StringBuilder();
//        assertSame(sb1FromIterable, joiner.appendTo(sb1FromIterable, set));
//        assertEquals(0, sb1FromIterable.length());

        StringBuilder sb1FromIterator = new StringBuilder();
//        assertSame(sb1FromIterator, joiner.appendTo(sb1FromIterator, set));
//        assertEquals(0, sb1FromIterator.length());

        StringBuilder sb2 = new StringBuilder();
//        assertSame(sb2, joiner.appendTo(sb2, array));
//        assertEquals(0, sb2.length());

        try {
            joiner.appendTo(NASTY_APPENDABLE, set);
        } catch (IOException e) {
            throw new AssertionError(e);
        }

        try {
            joiner.appendTo(NASTY_APPENDABLE, set.iterator());
        } catch (IOException e) {
            throw new AssertionError(e);
        }

        try {
            joiner.appendTo(NASTY_APPENDABLE, array);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }


    private static final Appendable NASTY_APPENDABLE = new Appendable() {
        @Override
        public Appendable append(CharSequence csq) throws IOException {
            throw new IOException();
        }
        @Override
        public Appendable append(CharSequence csq, int start, int end) throws IOException {
            throw new IOException();
        }
        @Override
        public Appendable append(char c) throws IOException {
            throw new IOException();
        }
    };



    @Test
    public void testJoin(){
        StringBuilder join = new StringBuilder();
        join = Joiner.on(",").useForNull("test").appendTo(join, "20", "30", "80").append(";");
        join = Joiner.on(",").useForNull("test").appendTo(join, "40", "50", "90").append(";");
//                .join(Lists.newArrayList("1", null, "2", "3"));


        System.out.println(join);

        Map<String, String> hello = Maps.newHashMap();
        hello.put("test1", "1");
        hello.put("test2", "2");
        hello.put("test3", "3");
        hello.put("test4", "4");
        System.out.println(hello);

        String join1 = Joiner.on(";").withKeyValueSeparator(":").join(hello);
        System.out.println(join1);


    }

    @Test
    public void createMapwithSplitter(){
        Map<String, String> split = Splitter.on(";").withKeyValueSeparator(":").split("test1:1;test4:4;test2:2;test3:3");
        System.out.println(split);
    }
}
