package com.jd.springboot.demo.config;

import com.jd.springboot.demo.domain.DependComponent;
import com.jd.springboot.demo.domain.TestComponent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * wangzhen23
 * 2018/9/13.
 */
@Configuration
public class Config {

    @Bean
    public DependComponent depend(@Qualifier("t1") TestComponent testComponent, @Qualifier("t2") TestComponent testComponent1) {
        System.out.println(testComponent1.getName() + "==========================================-------------" + testComponent.getName());
        return new DependComponent();
    }
}
