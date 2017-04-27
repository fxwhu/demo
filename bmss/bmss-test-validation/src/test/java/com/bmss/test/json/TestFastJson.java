package com.bmss.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import org.springframework.data.util.Pair;

import java.util.Date;

/**
 * Created by fengxuan1 on 2017/4/6.
 */
public class TestFastJson {


    public static void main(String[] args) {
        Student student = new Student();
        student.setBrith(new Date(new Date().getTime() - 1000 * 3600 * 24 * 3));
        String jsonString = JSON.toJSONString(student, SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(jsonString);
    }


    @Test
    public void testDeBug(){
        Pair<String, String> data = Pair.of("key", "\"the\"content");
        System.out.println(JSON.toJSONString(data));
    }

    static class Student{
        int age;
        @JSONField(serialize=false)
        String name;
        @JSONField(format = "yyyy-MM-dd")
        Date brith;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Date getBrith() {
            return brith;
        }

        public void setBrith(Date brith) {
            this.brith = brith;
        }
    }
}
