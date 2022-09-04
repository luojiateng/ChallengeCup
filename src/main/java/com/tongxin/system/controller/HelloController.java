package com.tongxin.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Title: HelloController
 * @ProjectName: xsyu
 * @date: 2022/4/18 22:56
 * @author: Luo
 */
@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/index")
    public String hello(@RequestBody body) {

        return "hello";
    }


}
