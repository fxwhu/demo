package com.bmss.test.springmvc.db.entity;


import com.bmss.test.springmvc.commons.ClazzTypeEnum;

import java.io.Serializable;

public class Clazz implements Serializable{
	
	private static final long serialVersionUID = -7238307241246696446L;

	private Integer id;

    private Integer schoolId;

    private Integer glassId;




    private Integer classId;

    private ClazzTypeEnum type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getGlassId() {
        return glassId;
    }

    public void setGlassId(Integer glassId) {
        this.glassId = glassId;
    }

    public ClazzTypeEnum getType() {
        return type;
    }

    public void setType(ClazzTypeEnum type) {
        this.type = type == null ? null : type;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}