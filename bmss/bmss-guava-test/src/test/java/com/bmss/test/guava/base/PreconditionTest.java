package com.bmss.test.guava.base;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.junit.Test;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class PreconditionTest {

    //checkNotNull 确保对象引用作为参数传递给调用方法不为空。
    //checkState(boolean expression) 确保涉及调用实例的状态，但不涉及任何参数来调用方法表达式的真相。
    //checkElementIndex( int index, int size, @Nullable String desc)：校验元素的索引值是否有效，index大于等于0小于size，在无效时显示错误描述信息。
    @Test
    public void testPrecondition(){
        String param = "0";

        Integer param1 = null;
        try {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(param) && Optional.fromNullable(param1).isPresent(),
                    "%s is null or empty, %s is null", "param", "param1");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


        try {
            Preconditions.checkNotNull(param1, "%s is null", "param1");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
