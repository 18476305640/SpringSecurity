package com.itheima.oauth.service;


import com.alibaba.fastjson.JSON;
import com.itheima.oauth.dao.UserDao;
import com.itheima.oauth.model.PermissionDto;
import com.itheima.oauth.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SpringDataUserDetailsService implements UserDetailsService {
    @Resource
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //登录账号
        log.info("**********登录的账号是："+username);
        //1）连接数据库认证
        //根据账号去查询数据库
        //因为Security存在User这个类，所以下面我们写的这个User不能再引入了，就能以下面的方式定义是我们写的User
        UserDto userDto = userDao.getUserByname(username);
        if(userDto == null){
            return null;
        }

        log.info("**********从数据库获取的用户信息："+userDto.toString());
        //2）连接数据库授权！！
        List<PermissionDto> list = userDao.getPermissionById(userDto.getId() + "");
        log.info("**********权限数组记录数："+list.size());
        List<String> permissions = new ArrayList<>();
        list.iterator().forEachRemaining(c -> permissions.add(c.getCode()));

        String[] perarray = new String[permissions.size()];
        permissions.toArray(perarray);
//        //这里暂时使用静态数据
//        UserDetails userDeatill = User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities(perarray).build();
//        return userDeatill;

        //创建userDetails
        //这里将user转为json,将整体user存入userDetails
        String principal = JSON.toJSONString(userDto);
        UserDetails userDetails =
                User.withUsername(principal).password(userDto.getPassword()).authorities(perarray).build();
        return userDetails;

    }
}