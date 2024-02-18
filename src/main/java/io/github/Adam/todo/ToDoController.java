package io.github.Adam.todo;

import io.github.Adam.DTO.TodoDTO;
import io.github.Adam.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    private final TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> findAllTodos() {
        log.info("Got request for All ToDos");
        List<TodoDTO> todos = todoService.findAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> toggleTodo(@PathVariable Integer id) {
        log.info("Toggling status of ToDo with id: {}", id);
        TodoDTO updatedTodo = todoService.toggleTodo(id);
        return ResponseEntity.ok(updatedTodo);
    }

    @PostMapping
    public ResponseEntity<TodoDTO> saveTodo(@Valid @RequestBody TodoDTO todoDTO) {
        log.info("Saving new ToDo");
        TodoDTO savedTodo = todoService.saveTodo(todoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id) {
        log.info("Request to delete Todo with id: {}", id);
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
