package com.jar.jpaexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("data")
public class DataController {

    @GetMapping("list")
    public String list(){
        return "data/list";
    }
}
