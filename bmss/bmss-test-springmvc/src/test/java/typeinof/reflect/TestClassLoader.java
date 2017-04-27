package typeinof.reflect;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import someDemo.typeinof.reflect.Demo;

import java.net.URL;

/**
 * Created by fengxuan1 on 2016/11/27.
 */
public class TestClassLoader {

    @Test
    public void testSystemClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> demoClass = systemClassLoader.loadClass("typeinof.reflect.Demo");
        Demo demo = (Demo)demoClass.newInstance();
        demo.setAge(10);
        System.out.println(JSON.toJSONString(demo));


        System.out.println(System.getProperty("sun.boot.class.path"));


        System.out.println("============" + System.getProperty("java.ext.dirs"));


        System.out.println(this.getClass().getClassLoader().getResource(""));

    }


    @Test
    public void testBootStrapClassLoader(){
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }//等价于System.getProperty("sun.boot.class.path")
    }


    @Test
    public void printClassLoader(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        while (classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);
    }


}
