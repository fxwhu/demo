package typeinof.reflect;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import someDemo.typeinof.reflect.Demo;
import someDemo.typeinof.reflect.Demo1;
import someDemo.typeinof.reflect.invoke.MyInvocationHandler;
import someDemo.typeinof.reflect.invoke.MySubject;
import someDemo.typeinof.reflect.invoke.Subject;
import someDemo.typeinof.reflect.invoke.cglib.ProxyFactory;
import someDemo.typeinof.reflect.invoke.cglib.TestSubject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by fengxuan1 on 2016/11/24.
 */
public class DemoTest {

    /**
     * Class.forName() ,new Class().getClass(),Class.class
     * newInstance（）需要无参
     */
    @Test
    public void testGetClass(){
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        try {
            demo1 = Class.forName("typeinof.reflect.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        demo2 = Demo.class;
        demo3 = new Demo().getClass();

        System.out.println("demo1: " + demo1);
        System.out.println("demo2: " + demo2);
        System.out.println("demo3: " + demo3);


    }

    @Test
    public void testInstanceClass(){
        Class<?> demo = null;
        demo = Demo1.class;
        Demo1 demo1 = null;
        Constructor<?>[] constructors = demo.getConstructors();
        try {
            demo1 = (Demo1) constructors[0].newInstance(9, "test");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(demo1));
    }


    /**
     *测试利用class获取构造器信息,与声明构造器的顺序有关
     */
    @Test
    public void testConstruct() throws ClassNotFoundException {
//        Class<?> demo = Class.forName("typeinof.reflect.Demo1");
        Class<?> demo = Demo1.class;
        try {
            demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Constructor<?>[] constructors = demo.getConstructors();
        for (int i = 0; i < constructors.length ; i++) {
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();
            System.out.println(JSON.toJSONString(parameterTypes));
            System.out.print("构造方法：");
            System.out.print(Modifier.toString(constructors[i].getModifiers()) + " ");
            System.out.print(constructors[i].getName());
            System.out.print("(");
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.print(parameterTypes[j].getName() + " arg" + j);
                if(j < parameterTypes.length - 1){
                    System.out.print(",");
                }
            }
            System.out.println("){}");
        }
    }

    /**
     *测试获取类中的public方法,有2点需要注意
     * 1.获取不到private
     */
    @Test
    public void testMethod(){
        Class<?> demo = Demo1.class;
        try {
            demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method[] methods = demo.getMethods();
        for (int i = 0; i < methods.length ; i++) {
            Class<?>[] parameterTypes = methods[i].getParameterTypes();
            System.out.print("构造方法：");
            System.out.print(Modifier.toString(methods[i].getModifiers()) + " ");
            System.out.print(methods[i].getReturnType().getName() + " ");
            System.out.print(methods[i].getName());
            System.out.print("(");
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.print(parameterTypes[j].getName() + " arg" + j);
                if(j < parameterTypes.length - 1){
                    System.out.print(",");
                }
            }
            Class<?>[] exceptionTypes = methods[i].getExceptionTypes();
            if(exceptionTypes.length > 0)
                System.out.print(") throws ");
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.print(exceptionTypes[j].getName() + " ");
                if(j < exceptionTypes.length -1)
                    System.out.print(",");
            }
            System.out.println("){}");
        }
    }

    @Test
    public void testInterface(){

    }


    /**
     *jdk的动态代理需要继承一个或者多个接口，是基于接口的
     */
    @Test
    public void testReflect(){
        MySubject mySubject = new MySubject();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Subject subject = (Subject) myInvocationHandler.bind(mySubject);
        System.out.println(subject.say("test", 20));
        if(subject instanceof MySubject){
            subject = (MySubject)subject;
            System.out.println(mySubject == subject);
            System.out.println(subject.say("test", 20));
            System.out.println(((MySubject)subject).hello());
        }
    }



    @Test
    public void testCgLib() {
        TestSubject test = ProxyFactory.getTestSubjectInstance("root");
        test.create();
        test.find();
        TestSubject rootTest = ProxyFactory.getTestSubjectInstance("test");
        rootTest.create();
        rootTest.find();

    }




}