package com.bmss.redis;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
public interface PersonRepository extends CrudRepository<Person, String> {
}
