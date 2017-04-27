package com.bmss.test.springmvc.util;

import com.bmss.test.springmvc.commons.DataEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fengxuan1 on 2016/12/30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
    DataEnum value() default DataEnum.MASTER;
}
