package springframeTest.applicationEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("classpath:/spring/springframe/applicationEvent/application-test" +
                ".xml");

        context.publishEvent(new ContentEvent1("test event publish"));
        context.publishEvent(new ContentEvent2("test2 event publish"));


    }
}
