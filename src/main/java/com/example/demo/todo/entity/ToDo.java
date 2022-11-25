package com.example.demo.todo.entity;

import lombok.*;

@Setter @Getter @ToString
//@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

    private long id; //할 일을 식별해주는 번호
    private String userId; // 할 일을 등록한 회원의 식별자
    private String title; // 할 일 내용
    private boolean done; // 할 일 완료 여부
    private static long seq;

    public ToDo(){
        this.id = ++seq;
    }

    public ToDo(String title){
        this();
        this.title = title;
        this.userId = "noname";

    }
}
