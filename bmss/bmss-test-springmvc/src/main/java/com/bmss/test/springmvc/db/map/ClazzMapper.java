package com.bmss.test.springmvc.db.map;

import com.bmss.test.springmvc.commons.ClazzVo;
import com.bmss.test.springmvc.commons.DataEnum;
import com.bmss.test.springmvc.db.entity.Clazz;
import com.bmss.test.springmvc.util.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClazzMapper {
	
    @DataSource(DataEnum.MASTER)
    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazz record);

//    @DataSource("salve")
    List<ClazzVo> selectByTechNo(@Param("teacheno") Integer teacherNo);
    
    int updateByPrimaryKey(Clazz record);

    List<ClazzVo> selectByPaperId(@Param("paperid") Long paperId, @Param("classid") Integer classId);

    List<Long> getPaperIdByClassId(@Param("classid") Integer classId);

	List<ClazzVo> selectClassVoById(@Param("paperId") long paperId, @Param("teacherNo") int no);
}