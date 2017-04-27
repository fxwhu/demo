package testSpringBean.testfianl;

import com.alibaba.fastjson.JSON;

/**
 * Created by fengxuan1 on 2016/11/19.
 */
public class TestFianl {

    private final Test a;

    {
        a = new Test();
    }

    public TestFianl() {
        System.out.println(JSON.toJSONString(a));
    }

    public void test(){
        a.setAge(a.getAge() + 1);
        a.setMessage(a.getMessage() + "1");
    }

    public static void main(String[] args) {
        TestFianl testFianl = new TestFianl();
        testFianl.test();
        TestFianl testFianl1 = new TestFianl();
        testFianl1.test();
    }
}
