package com.jd.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * wangzhen23
 * 2018/9/5.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String simpleIndex(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "/welcome");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "views/index";
    }

    @GetMapping(value = "welcome")
    public String welcome(){
        return "/views/welcome";
    }
}
