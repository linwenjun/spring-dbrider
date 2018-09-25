package cn.thoughtworks.school.training.todoservice.repository;

import cn.thoughtworks.school.training.todoservice.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
