package com.jd.springboot.demo.mapper;

import com.jd.springboot.demo.domain.UserEntity;

import java.util.List;

/**
 * wangzhen23
 * 2018/9/5.
 */
public interface UserDemoMapper {
    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    int insert(UserEntity user);

    int update(UserEntity user);

    int delete(Long id);
}
