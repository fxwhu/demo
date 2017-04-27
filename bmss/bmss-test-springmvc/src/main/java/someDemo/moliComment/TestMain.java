package someDemo.moliComment;

import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class TestMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("classpath:/spring/application-test.xml");
        String[] names = context.getBeanDefinitionNames();
        System.out.println(JSON.toJSONString(names));
        AService a = context.getBean(AService.class);
        a.test();
        BService b = context.getBean(BService.class);
        b.test();
        CService c = context.getBean(CService.class);
        c.test();
    }

}
