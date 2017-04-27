package com.bmss.test.springmvc.db.map;

import com.alibaba.fastjson.JSON;
import com.bmss.test.springmvc.commons.ClazzVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by fengxuan1 on 2016/12/30.
 */
public class ClazzMapperTest {

    ClazzMapper clazzMapper;

    @Before
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-db.xml");
        clazzMapper= context.getBean(ClazzMapper.class);
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void selectByTechNo() throws Exception {
        for (int i = 0; i < 2; i++) {
            List<ClazzVo> clazzVos = clazzMapper.selectByTechNo(100001);
            System.out.println("==========================");
            System.out.println(JSON.toJSONString(clazzVos));
        }
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

    @Test
    public void selectByPaperId() throws Exception {

    }

    @Test
    public void getPaperIdByClassId() throws Exception {

    }

    @Test
    public void selectClassVoById() throws Exception {

    }

}