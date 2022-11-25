package com.example.demo.rest;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/json")
@Slf4j
public class RestJsonController {

    @PostMapping("/major")
    public List<String> major(@RequestBody List<String> nickname){
        log.info("/json/major POST request! -{}입니다",nickname);
        return null;
    }

    @GetMapping("/user4/{userNum}")
    public String user4(@PathVariable("userNum") int num){
        return String.format("회원번호는 %d번입니다.",num);
    }


    @PutMapping("/bbs")
    public void bbs(@RequestBody Article article){
        log.info("/json/bbs PUT request! -{}",article);
    }



    @Setter @Getter @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Article{
        private long id;
        private String title;
        private String content;
        private String writer;
    }
}
