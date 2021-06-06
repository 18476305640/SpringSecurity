package com.itheima.oauth.controller;

import com.itheima.oauth.dao.UserDao;
import com.itheima.oauth.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @Autowired
    private UserDao userDao;
    @GetMapping("/get")
    public String getUserData() {
        UserDto userDto = userDao.getUserByname("root");
        return userDto.toString();
    }

}
