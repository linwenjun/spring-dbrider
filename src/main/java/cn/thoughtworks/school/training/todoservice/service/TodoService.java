package cn.thoughtworks.school.training.todoservice.service;

import cn.thoughtworks.school.training.todoservice.model.Todo;
import cn.thoughtworks.school.training.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getTodo() {
        return todoRepository.findAll();
    }
}
