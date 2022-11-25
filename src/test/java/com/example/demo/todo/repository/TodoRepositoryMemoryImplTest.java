package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoRepositoryMemoryImplTest {

    @Autowired
    TodoRepository repository;

    @Test
    @DisplayName("조회시 데이터의 길이는 무조건 3개")
    void findAllTest(){
        //given : 테스트 시 필요한 데이터
        //when : 테스트의 실제 상황
        List<ToDo> toDoList = repository.findAll();
        //then
        assertEquals(3,toDoList.size());
        assertNotNull(toDoList);
    }

    @Test
    @DisplayName("아이디가 2번일시 데이터 값들은 박영희, 산책가기, false값이여야한다")
    void findOneTest(){
        //given
        long id = 2L;
        //when
        ToDo one = repository.findOne(id);
        //then
        assertEquals("박영희",one.getUserId());
        assertEquals("산책 가기",one.getTitle());
        assertEquals(false,one.isDone());
    }

    @Test
    @DisplayName("1~3번 삭제할시 true, 그 이상의 값 입력시 false")
    void removeTest(){
        //given
        long id = 2L;
        //when
        boolean flag = repository.remove(id);
        ToDo one = repository.findOne(id);
        //then
        assertTrue(flag);
        assertNull(one);
    }

    @Test
    @DisplayName("새로운 4번 할 일을 등록시, 전체목록의 개수가 4여야한다.")
    void saveTest(){
        //given
        ToDo todo = new ToDo(4L,"4번째인간","쉬기",true);
        //when
        boolean flag = repository.save(todo);
        List<ToDo> toDoList = repository.findAll();
        //then
        assertTrue(flag);
        assertEquals(4,toDoList.size());
        assertEquals(4L,todo.getId());
    }


}