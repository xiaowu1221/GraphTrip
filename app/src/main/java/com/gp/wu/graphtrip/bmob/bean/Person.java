package com.gp.wu.graphtrip.bmob.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by wu on 2017/3/26.
 */

public class Person extends BmobObject{
    private String name;
    private String address;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
