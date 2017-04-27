package someDemo.typeinof.reflect.invoke;

/**
 * Created by fengxuan1 on 2016/11/25.
 */
public class MySubject implements Subject {
    @Override
    public String say(String name, int age) {
        return (name + ", " + age);
    }

    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
