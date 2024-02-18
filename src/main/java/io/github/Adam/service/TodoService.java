package io.github.Adam.service;

import io.github.Adam.DTO.TodoDTO;
import io.github.Adam.todo.Todo;
import io.github.Adam.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TodoDTO> findAllTodos() {
        return repository.findAll().stream()
                .map(this::convertToTodoDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public TodoDTO toggleTodo(Integer id) {
        return repository.findById(id)
                .map(todo -> {
                    todo.setDone(!todo.isDone());
                    return convertToTodoDTO(repository.save(todo));
                })
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
    }

    @Transactional
    public TodoDTO saveTodo(TodoDTO todoDTO) {
        Todo todo = convertToTodoEntity(todoDTO);
        Todo savedTodo = repository.save(todo);
        return convertToTodoDTO(savedTodo);
    }

    @Transactional
    public void deleteTodo(Integer id) {
        if (!repository.existsById(id)) {
            throw new TodoNotFoundException("Todo not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private TodoDTO convertToTodoDTO(Todo todo) {
        return new TodoDTO(todo.getId(), todo.getText(), todo.isDone());
    }

    private Todo convertToTodoEntity(TodoDTO todoDTO) {
        return new Todo(todoDTO.getId(), todoDTO.getText(), todoDTO.isDone());
    }

    public class TodoNotFoundException extends RuntimeException {
        public TodoNotFoundException(String message) {
            super(message);
        }
    }

}
