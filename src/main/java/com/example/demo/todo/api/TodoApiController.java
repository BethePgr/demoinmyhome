package com.example.demo.todo.api;


import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor//final이나 @notnull이 붙은 필드 값들로 이루어진 생성자 자동 생성(@autowired 붙어진 상태의 생성자)
public class TodoApiController {
    private final TodoService service;
//    할 일 전체 목록 요청
//    @GetMapping
//    public ResponseEntity<?> todods(){
//        log.info("/api/todos GET request!");
//        FindAllDTO findAllDTO = service.findAllServ();
//        return ResponseEntity.ok().body(service.findAllServ());
//    }

    @GetMapping
    public ResponseEntity<?> todos(){
        log.info("/api/todos GET request!");
        FindAllDTO allServ = service.findAllServ();
        return ResponseEntity.ok().body(allServ);
    }



    //할 일 목록 등록 요청
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ToDo newTodo){
        newTodo.setUserId("noname");
        log.info("/api/todos POST request! -{}!",newTodo);
        try{
            FindAllDTO dto = service.createServ(newTodo);
            if(dto == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);
        }catch(RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //할 일 개별 조회 요청
    //URI : /api/todos/3 : GET => 3번 할 일만 조회해서 클라이언트에게 리턴
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable long id){
        log.info("/api/todos/{} GET request!",id);
        try {
            TodoDto ones = service.findOne(id);
            if (ones == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(ones);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //할 일 삭제 요청
    //URI : /api/todos/3 : DELETE => 3번 할 일을 삭제 후 삭제된 이후 갱신된 할 일 목록 리턴
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        log.info("/api/todos/{} DELETE request!",id);

        try{
            FindAllDTO dtos = service.deleteServ(id);
            return ResponseEntity.ok().body(dtos);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }




}
