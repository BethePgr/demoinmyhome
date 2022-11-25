package com.example.demo.todo.service;

import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

     /*
        할 일 목록조회 중간처리
        1.컨트롤러에게 userId를 뺸 할 일 리스트를 전달한다.
        2.할 일 목록의 카운트를 세서 따로 추가해서 전달한다.
      */

    public FindAllDTO findAllServ(){
        return new FindAllDTO(repository.findAll());
    }

    public FindAllDTO createServ(final ToDo newTodo){
        if(newTodo == null){
            log.warn("newTodo cannot be null!");
            throw new RuntimeException("newTodo cannot be null!");
        }
        boolean flag = repository.save(newTodo);

        if (flag) log.info("새로운 할 일 [Id : {}]가 저장되었습니다.",newTodo.getId());
        return flag ? findAllServ() : null;
    }
    public TodoDto findOne(long id){
        ToDo onetodo = repository.findOne(id);
        if(onetodo == null){
            log.warn("onetodo cannot be null!!");
            throw new RuntimeException("onetodo cannot be null");
        }
        TodoDto onedto = new TodoDto(onetodo);
        if (onedto != null) log.info("할 일 id[{}]가 보여집니다.",id);
        return onedto;
    }

    public FindAllDTO deleteServ(long id){
        boolean flag = repository.remove(id);

        //삭제 실패한 경우
        if (!flag){
            log.warn("delete fail! not found id[{}]",id);
            throw new RuntimeException("delete fail!");
        }
        return findAllServ();
    }



}

