package com.jd.springboot.demo.params;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 测试参数
 * wangzhen23
 * 2018/9/5.
 */
public class TestData {
    String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" + name + "," + date + " }";
    }
}
