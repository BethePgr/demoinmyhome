package com.example.demo.todo.dto;

import com.example.demo.todo.entity.ToDo;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    private long id;
    private String title;
    private boolean done;

    //ToDo에서 TodoDto가 필요한 코드를 빼오는 생성자
    public TodoDto(ToDo toDo){

        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.done = toDo.isDone();
    }
}
