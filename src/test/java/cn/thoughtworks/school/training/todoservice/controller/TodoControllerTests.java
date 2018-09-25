package cn.thoughtworks.school.training.todoservice.controller;

import cn.thoughtworks.school.training.todoservice.repository.TodoRepository;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@DBUnit(caseSensitiveTableNames = true, escapePattern = "`")
@Transactional
public class TodoControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TodoRepository todoRepository;

    @Test
    @DataSet("datasets/todos.yml")
    public void should_return_todo() throws Exception {
        mockMvc.perform(get("/todos")
                .header("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)));
    }

}
