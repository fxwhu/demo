package com.bmss.test.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
public class MultiUser {

    @NotBlank
    @Size(min = 2)
    String name;

    @NotBlank
    @Size(min = 2)
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
