package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/param")
public class RestParamController {

    @GetMapping("/user")
    public String userName(HttpServletRequest request){
        String name = request.getParameter("name");
        return String.format("당신의 이름은 %s입니다",name);
    }

}
