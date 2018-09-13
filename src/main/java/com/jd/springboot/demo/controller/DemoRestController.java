package com.jd.springboot.demo.controller;

import com.jd.springboot.demo.domain.UserEntity;
import com.jd.springboot.demo.enums.Events;
import com.jd.springboot.demo.enums.States;
import com.jd.springboot.demo.mapper.UserDemoMapper;
import com.jd.springboot.demo.mapper.UserMapper;
import com.jd.springboot.demo.params.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * wangzhen23
 * 2018/9/4.
 */
@RestController
public class DemoRestController {
    private Logger logger = LoggerFactory.getLogger(DemoRestController.class);

    @Resource
    StateMachine<States, Events> stateMachine;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserDemoMapper userDemoMapper;

    @RequestMapping("/string")
    String home() {
        return "Hello World Demo!";
    }

    @RequestMapping("/data")
    TestData recive(TestData testData) {
        logger.debug("" + testData);
        return testData;
    }

    @RequestMapping("/add")
    Boolean addUser(UserEntity user) {
        int result = 0;
        logger.debug("add user ______________" + user.getUserName());
        if (user != null)
            result = userMapper.insert(user);
        return result > 0;
    }

    @RequestMapping("/get")
    List<UserEntity> getUsers() {
        logger.debug("get all data");
        return userMapper.getAll();
    }

    @RequestMapping("/update")
    Boolean updateUser(Long id) {
        logger.debug("update user,id:" + id);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setUserName("xxxxxxxxxx" + new Random().nextDouble());
        userEntity.setPassWord("ppppppp" + new Random().nextDouble());
        int result = userDemoMapper.update(userEntity);
        return result > 0;
    }

    @RequestMapping("/state")
    boolean doSignals() {
//        stateMachine.start();
        stateMachine.sendEvent(Events.EVENT1);
        stateMachine.sendEvent(Events.EVENT2);
        return true;
    }
}
