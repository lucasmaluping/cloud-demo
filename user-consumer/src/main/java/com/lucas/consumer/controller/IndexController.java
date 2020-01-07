package com.lucas.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Lucas
 * @Date 2019/12/19 22:09
 * @Version 1.0
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("index.html")
    public String index() {
        return "index";
    }
    @RequestMapping("index2.html")
    public String index2() {
        return "index2";
    }
}
