package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class Index {

    @RequestMapping("")
    public Object getIndex() {
        HashMap<String, Object> res = new HashMap<>();
        res.put("name", "wang12323");
        return res;
    }
}
