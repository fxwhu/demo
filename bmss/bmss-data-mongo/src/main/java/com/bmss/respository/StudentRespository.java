package com.bmss.respository;

import com.bmss.entiy.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
public interface StudentRespository extends MongoRepository<Student, String> {

    List<Student> findByNameAndAge(String name, int age);

    List<Student> findByNameLike(String name);

    List<Student> findByCreateTimeLessThan(String createTime);
}
