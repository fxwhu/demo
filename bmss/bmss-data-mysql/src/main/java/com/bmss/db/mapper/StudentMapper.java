package com.bmss.db.mapper;

import com.bmss.db.pojo.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    Student selectByNameAndNo(@Param("name") String name, @Param("no") String no);

    int updateByPrimaryKeySelective(Student record);

    int update(Student record);

    int updateByName(Student record);

    void insertAndUpdate(Student record);


}