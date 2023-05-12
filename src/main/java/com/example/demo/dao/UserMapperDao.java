package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

@Mapper
public interface UserMapperDao {
    
    @Select("SELECT * FROM t_user WHERE username=#{name}")
    User findByName(String name);
}
