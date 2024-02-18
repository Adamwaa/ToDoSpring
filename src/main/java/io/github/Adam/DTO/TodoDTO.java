package io.github.Adam.DTO;

import io.github.Adam.todo.Todo;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private int id;
    private String text;
    private boolean done;

    public TodoDTO(Todo todo) {
        this.text = todo.getText();
        this.done = todo.isDone();
    }

    public TodoDTO(Integer id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }
}
