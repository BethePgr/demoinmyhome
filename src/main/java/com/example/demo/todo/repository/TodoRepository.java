package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;

import java.util.List;

//인터페이스란 확실하게 정해진 인물이 아닌 역할을 의미한다.
public interface TodoRepository {
    //인터페이스에서는 추상적으로 함수를 만든다
    //crud 메서드 만들기

    //저장
    boolean save(ToDo todo);

    //모든 목록 조회하기
    List<ToDo> findAll();

    //목록 하나만 조회하기
    ToDo findOne(long id);

    //할 일 삭제하기
    boolean remove(long id);




}
