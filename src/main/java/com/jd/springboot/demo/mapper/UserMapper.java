package com.jd.springboot.demo.mapper;

import com.jd.springboot.demo.domain.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * wangzhen23
 * 2018/9/5.
 */
public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "userName",  column = "user_name"),
            @Result(property = "passWord", column = "pass_word")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "userName",  column = "user_name"),
            @Result(property = "passWord", column = "pass_word")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(user_name,pass_word) VALUES(#{userName}, #{passWord})")
    int insert(UserEntity user);

    @Update("UPDATE users SET user_name=#{userName},pass_word=#{passWord} WHERE id =#{id}")
    int update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    int delete(Long id);

}
