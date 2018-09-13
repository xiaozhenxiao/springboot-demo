package com.jd.springboot.demo;

import com.jd.springboot.demo.domain.DependComponent;
import com.jd.springboot.demo.enums.Events;
import com.jd.springboot.demo.enums.States;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.statemachine.StateMachine;

import javax.annotation.Resource;


@SpringBootApplication
@MapperScan("com.jd.springboot.demo.mapper")
public class JdSpringbootHelloworldApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    public static void main(String[] args) {
        SpringApplication.run(JdSpringbootHelloworldApplication.class, args);
    }

    @Resource
    private StateMachine<States, Events> stateMachine;

    @Resource
    private DependComponent dependComponent;

    @Override
    public void run(String... args) {
        stateMachine.start();
//        stateMachine.sendEvent(Events.EVENT1);
//        stateMachine.sendEvent(Events.EVENT2);

        System.out.println("result--------------" + dependComponent.getName());
    }
}
