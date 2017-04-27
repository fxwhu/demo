package com.bmss.test.dubbo.dao;

import com.bmss.test.dubbo.entity.Spitter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fengxuan1 on 2016/12/1.
 */
public interface SpitterMapper {

    Spitter getByName(@Param("name") String name);

    void insertBatch(@Param("spitters")List<Spitter> spitterList);

    List<Spitter> getAll();
}
