package cn.thoughtworks.school.training.todoservice.controller;


import cn.thoughtworks.school.training.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public ResponseEntity getTodo() {
        return ResponseEntity.ok(todoService.getTodo());
    }
}
