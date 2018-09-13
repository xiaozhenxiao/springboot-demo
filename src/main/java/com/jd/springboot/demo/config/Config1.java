package com.jd.springboot.demo.config;

import com.jd.springboot.demo.domain.TestComponent;
import com.jd.springboot.demo.enums.Events;
import com.jd.springboot.demo.enums.States;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * wangzhen23
 * 2018/9/6.
 */
@Configuration
@EnableStateMachine
class Config1 extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.STATE1)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.STATE1).target(States.STATE2)
                .event(Events.EVENT1)
                .and()
                .withExternal()
                .source(States.STATE2).target(States.STATE1)
                .event(Events.EVENT2);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
                .withConfiguration()
                .listener(listener());
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {

            @Override
            public void transition(Transition<States, Events> transition) {
                if (transition.getTarget().getId() == States.STATE1) {
                    System.out.println("==================== to target state1");
                    return;
                }

                if (transition.getSource().getId() == States.STATE1
                        && transition.getTarget().getId() == States.STATE2) {
                    System.out.println("=============from state1 to state2!");
                    return;
                }
            }
        };
    }

    @Bean(name = "t1", autowire = Autowire.BY_NAME)
    public TestComponent getTestComponet() {
        return new TestComponent("test");
    }

    @Bean(name = "t2", autowire = Autowire.BY_NAME)
    public TestComponent getTestComponet1() {
        return new TestComponent("test1");
    }

}
