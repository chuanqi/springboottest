package com.xd.controller;

import com.xd.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: xu
 * @Date: 2019-04-17
 * @Time: 19:53
 */
@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(App.class);

    @RequestMapping("/")
    public String greeting() {
        return "Hello World!";
    }

    @RequestMapping("/a")
    public String a() {
        return "Hello a!";
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hello(@RequestParam String name) {
        return "Hello " + name + ", I'm from port " + port;
    }
}
