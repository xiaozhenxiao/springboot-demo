package com.jd.springboot.demo.statemachine;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 状态机监听器
 * @see com.jd.springboot.demo.config.Config1
 * @see com.jd.springboot.demo.JdSpringbootHelloworldApplication
 * @see com.jd.springboot.demo.controller.DemoRestController#doSignals()
 * wangzhen23
 * 2018/9/6.
 */
@WithStateMachine
public class StateMachineListener {

    @OnTransition(target = "STATE1")
    public void toState1() {
        System.out.println("--------------------to target STATE1---------------------");
    }

    @OnTransition(target = "STATE2")
    public void toState2() {
        System.out.println("--------------------to target STATE2---------------------");
    }
}
