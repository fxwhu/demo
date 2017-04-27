package com.bmss.test.vo;

import javax.validation.constraints.Min;

/**
 * Created by fengxuan1 on 2017/3/24.
 */
public class ClassInfo {

    private String className;

    private int nums;

    private String headTeacher;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Min(1)
    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(String headTeacher) {
        this.headTeacher = headTeacher;
    }
}
