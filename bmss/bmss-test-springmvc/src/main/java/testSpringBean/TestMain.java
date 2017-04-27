package testSpringBean;

import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class TestMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("classpath:/spring/application-test1.xml");
        String[] names = context.getBeanDefinitionNames();
        System.out.println(JSON.toJSONString(names));
//        由此可以证明有spring默认生成的bean是单例
        /*A a = context.getBean(A.class);
        a.test();
        A a1 = context.getBean(A.class);
        a1.test();*/
        C c = context.getBean(C.class);
        c.test();
    }

}
