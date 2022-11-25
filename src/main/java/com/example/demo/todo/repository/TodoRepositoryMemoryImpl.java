package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//만들어놓은 todorepository에서 우리는 저장공간을 메모리로 결정하였다! 즉 배우를 메모리로 결정하였음을 나타내는 클래스
@Repository
public class TodoRepositoryMemoryImpl implements TodoRepository{

    private static final Map<Long, ToDo> toDoMap = new HashMap<>();

    static{
        toDoMap.put(1L, new ToDo("저녁밥 만들기"));
        toDoMap.put(2L, new ToDo("산책가기"));
        toDoMap.put(3L, new ToDo("노래연습하기"));
    }

    @Override
    public boolean save(ToDo todo) {
        if (todo == null) return false;
        toDoMap.put(todo.getId(),todo);
        return true;
    }

    @Override
    public List<ToDo> findAll() {
        List<ToDo> toDoList = new ArrayList<>();

        for (Long id : toDoMap.keySet()) {
            ToDo todo = toDoMap.get(id);
            toDoList.add(todo);
        }
        return toDoList;
    }

    @Override
    public ToDo findOne(long id) {
        return toDoMap.get(id);
    }

    @Override
    public boolean remove(long id) {
        ToDo todo = toDoMap.remove(id);
        return todo != null;
    }
}
