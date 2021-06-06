package com.itheima.oauth.dao;

import com.itheima.oauth.model.PermissionDto;
import com.itheima.oauth.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
@Mapper
public interface UserDao {
    UserDto getUserByname(@Param("username") String username);
    List<PermissionDto> getPermissionById(@Param("id") String id);
}
