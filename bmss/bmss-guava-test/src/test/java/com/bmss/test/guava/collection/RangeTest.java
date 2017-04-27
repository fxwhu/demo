package com.bmss.test.guava.collection;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import org.junit.Test;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class RangeTest {


    @Test
    public void testRange(){
        Range<Integer> integerRange = Range.greaterThan(18);

        Function<OrderingTest.Person, Integer> function =
        new Function<OrderingTest.Person, Integer>() {
            @Override
            public Integer apply(OrderingTest.Person input) {
                return input.getAge();
            }
        };

        boolean containsAll = integerRange.containsAll(Lists.newArrayList(1, 2, 5));

        OrderingTest.Person person = new OrderingTest.Person("feng", 19);

        boolean isAllowed = Predicates.compose(integerRange, function).apply(person);

        System.out.println("containsAll:" + containsAll + " ,isAllowed:" + isAllowed);
    }

}
