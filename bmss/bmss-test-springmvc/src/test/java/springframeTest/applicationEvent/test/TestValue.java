package springframeTest.applicationEvent.test;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springframeTest.applicationEvent.byAutowire.PublisherEvent;
import springframeTest.applicationEvent.example1.EmailService;

/**
 * Created by fengxuan1 on 2016/12/7.
 */
public class TestValue {
    TestBeanValue test;

    EmailService emailService;

    PublisherEvent publisherEvent;

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("classpath:/spring/springframe/applicationEvent/application-test.xml");
         test = context.getBean(TestBeanValue.class);
         emailService = context.getBean(EmailService.class);
         publisherEvent = context.getBean(PublisherEvent.class);
    }

    @Test
    public void testValue(){
        System.out.println(JSON.toJSONString(test.getNames().size()));
    }

    @Test
    public void sendEmail(){
        emailService.sendEmail("known.spammer@example.org", "test hello");
    }

    @Test
    public void sendEmailByAutowire(){
    }

    @Test
    public void testBlog(){
        publisherEvent.sendEmail("test@publish1.com", "test1");

    }
}