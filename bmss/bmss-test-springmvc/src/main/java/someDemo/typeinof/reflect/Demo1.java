package someDemo.typeinof.reflect;

/**
 * Created by fengxuan1 on 2016/11/24.
 */
public class Demo1 {

    private String name;

    private int age;

    public Demo1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Demo1() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test() throws IllegalAccessError{

    }

    private void test2() throws RuntimeException{

    }

    protected void test3(){}
}


