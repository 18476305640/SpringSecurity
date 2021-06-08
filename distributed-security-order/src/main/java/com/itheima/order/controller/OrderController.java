package com.itheima.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping(value = "/r1")
    @PreAuthorize("hasAnyAuthority('p1')") //拥有p1权限方可访问此url
    public String r1() {
        return "访问资源1";
    }
    @GetMapping(value = "/r2")
    @PreAuthorize("hasAnyAuthority('p2')") //拥有p2权限方可访问此url
    public String r2() {
        return "访问资源2";
    }
    @GetMapping(value = "/r3")
    @PreAuthorize("hasAnyAuthority('p3')") //拥有p3权限方可访问此url
    public String r3() {
        return "访问资源3";
    }
}
