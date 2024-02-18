package io.github.Adam;

import io.github.Adam.DTO.TodoDTO;
import io.github.Adam.service.TodoService;
import io.github.Adam.todo.Todo;
import io.github.Adam.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class TodoServiceTest {

@Mock
private TodoRepository todoRepository;

@InjectMocks
private TodoService todoService;

private Todo todo;
private TodoDTO todoDTO;

@BeforeEach
public void setUp() {
        todo = new Todo(1, "Test Todo", false);
        todoDTO = new TodoDTO(1, "Test Todo", false);
        }

@Test
public void testFindAllTodos() {
        when(todoRepository.findAll()).thenReturn(List.of(todo));
        List<TodoDTO> result = todoService.findAllTodos();
        assertEquals(1, result.size());
        assertEquals(todo.getText(), result.get(0).getText());
        assertEquals(todo.isDone(), result.get(0).isDone());
        }

    @Test
    public void testToggleTodo() {
        when(todoRepository.findById(any(Integer.class))).thenReturn(Optional.of(todo));
        when(todoRepository.save(any(Todo.class))).thenReturn(todo);
        TodoDTO result = todoService.toggleTodo(1);
        assertEquals(todo.getText(), result.getText());
        verify(todoRepository).save(todo);
    }

    @Test
    public void testSaveTodo() {
        when(todoRepository.save(any(Todo.class))).thenReturn(todo);
        TodoDTO result = todoService.saveTodo(todoDTO);
        assertEquals(todo.getText(), result.getText());
        assertEquals(todo.isDone(), result.isDone());
    }

    @Test
    public void testDeleteTodo() {
        when(todoRepository.existsById(any(Integer.class))).thenReturn(true);
        todoService.deleteTodo(1);
        verify(todoRepository).deleteById(1);
    }

    @Test
    public void testDeleteTodo_NotFound() {
        when(todoRepository.existsById(any(Integer.class))).thenReturn(false);
        assertThrows(TodoService.TodoNotFoundException.class, () -> todoService.deleteTodo(1));
    }

}
