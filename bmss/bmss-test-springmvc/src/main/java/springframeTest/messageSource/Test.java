package springframeTest.messageSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("classpath:/spring/springframe/messageSource/application-test" +
                ".xml");

        String name = context.getMessage("customer.name",
                new Object[] { 28,"http://www.eeee.com" }, Locale.US);

        System.out.println("Customer name (English) : " + name);

        String namechinese = context.getMessage("customer.name",
                new Object[] {28, "http://www.eeee.com" },
                Locale.SIMPLIFIED_CHINESE);

        System.out.println("Customer name (Chinese) : " + namechinese);

    }
}
