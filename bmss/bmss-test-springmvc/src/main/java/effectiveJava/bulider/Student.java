package effectiveJava.bulider;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fengxuan1 on 2016/11/21.
 */

public class Student{
    private String name;
    private String stuno;
    private int age;
    private int gender;
    private Date birthday;
    private String school;
    public static class Builder{
        //必须的属性参数
        private final String name;
        private final String stuno;

        //可选的属性参数：需要设置初始值
        private int age = 0;
        private int gender = 1;
        private Date birthday = null;

        public Builder(String name,String stuno){
            this.name = name;
            this.stuno = stuno;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }
        public Builder setGender(int gender){
            this.gender = gender;
            return this;
        }
        public Builder setBirthday(Date birthday){
            this.birthday = birthday;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }
    private Student(Builder builder){
        name = builder.name;
        stuno = builder.stuno;
        age = builder.age;
        gender = builder.gender;
    }

    public static void main(String[] args) throws ParseException {
        Student test = new Builder("test", "123").setAge(10).setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse
                ("1990-12-09")).setGender(20).build();

        System.out.println(JSON.toJSONString(test));

        System.out.println("==========");
    }
}