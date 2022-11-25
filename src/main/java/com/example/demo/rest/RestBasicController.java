package com.example.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
public class RestBasicController {

    @GetMapping("/china")
    public List<String> food(){
        List<String> foodList = Arrays.asList("마파두부","꿔바로우");
        return foodList;
    }

}
