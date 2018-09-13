package com.jd.springboot.demo.domain;

/**
 * wangzhen23
 * 2018/9/13.
 */
public class TestComponent {
    private String name = "testName";

    public TestComponent() {
    }

    public TestComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
