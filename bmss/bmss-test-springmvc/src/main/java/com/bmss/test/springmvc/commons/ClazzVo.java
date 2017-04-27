package com.bmss.test.springmvc.commons;

import java.io.Serializable;

/**
 * Created by fengxuan1 on 2016/11/23.
 */
public class ClazzVo implements Serializable{

    private Integer classId;

    private String classInfo;
    
    private boolean isSelected;

    public ClazzVo() {
    }

    public Integer getClassId() {
        return this.classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassInfo() {
        return this.classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
    
}