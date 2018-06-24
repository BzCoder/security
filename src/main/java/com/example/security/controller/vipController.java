package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author BaoZhou
 * @date 2018/6/22
 */
@Controller
public class vipController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/level1/1")
    public String one() {
        return "level1/1";
    }

    @GetMapping("/level2/2")
    public String two() {
        return "level2/2";
    }

    @GetMapping("/level3/3")
    public String three() {
        return "level3/3";
    }
}
