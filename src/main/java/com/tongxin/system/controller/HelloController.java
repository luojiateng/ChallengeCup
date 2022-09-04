package com.tongxin.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.hutool.core.lang.Console.log;

/**
 * @Description:
 * @Title: HelloController
 * @ProjectName: xsyu
 * @date: 2022/4/18 22:56
 * @author: Luo
 */
@RestController
@RequestMapping
@Slf4j
public class HelloController {

    @GetMapping("/index")
    public String hello() {
        return "hello";
    }


}
