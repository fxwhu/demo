package com.bmss.test.guava.base;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class OptionalTest {

    //static fromNullable 如果nullableReference非空，返回一个包含引用Optional实例;否则返回absent()。
    //optional.get() 返回所包含的实例，它必须存在。
    //or 返回所包含的实例(如果存在);否则为默认值。
    @Test
    public void testOptional(){
        Integer i = null;

        Optional<Integer> optional = Optional.fromNullable(i);

        Integer or = optional.or(0);

        System.out.println(optional.isPresent() + "===="+ or);


        Boolean flag = null;

        flag = Optional.fromNullable(flag).or(true);

        System.out.println(flag);
    }
}
