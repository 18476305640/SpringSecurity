package com.itheima.springsecurity.dao;

import com.itheima.springsecurity.model.PermissionDto;
import com.itheima.springsecurity.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    UserDto getUserByname(@Param("username") String username);
    List<PermissionDto> getPermissionByname(@Param("id") String id);
}
