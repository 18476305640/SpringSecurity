package com.itheima.order.controller;

import com.itheima.order.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {
    @GetMapping(value = "/r1")
    @PreAuthorize("hasAuthority('p1')")//拥有p1权限方可访问此url
    public String r1(){
        //获取用户身份信息
        UserDTO  userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("********************用户信息是："+userDTO.toString());
        return userDTO.getFullname()+"访问资源1";
    }
    @GetMapping(value = "/r1c")
    @PreAuthorize("hasAnyAuthority('p1')") //拥有p1权限方可访问此url
    public String r1c() {
        return "访问资源1";
    }
//    @GetMapping(value = "/r2")
//    @PreAuthorize("hasAnyAuthority('p2')") //拥有p2权限方可访问此url
//    public String r2() {
//        return "访问资源2";
//    }
    @GetMapping(value = "/r3")
    @PreAuthorize("hasAnyAuthority('p3')") //拥有p3权限方可访问此url
    public String r3() {
        return "访问资源3";
    }
}
