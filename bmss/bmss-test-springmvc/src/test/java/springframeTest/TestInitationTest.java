package springframeTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
public class TestInitationTest {

    TestInitation testInitation;

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("classpath:spring/application-testSpringFrame-1.xml");
        TestInitation bean = context.getBean(TestInitation.class);
    }

    @Test
    public void setTestInitation(){
    }
}