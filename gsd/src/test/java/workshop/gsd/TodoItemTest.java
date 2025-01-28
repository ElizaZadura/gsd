package workshop.gsd;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoItemTest {
    @Test
    void shouldCreateTodoItemWithCorrectData() {
        int expectedId = 1;
        String expectedTitle = "title";
        String expectedDescription = "description";
        LocalDate expectedDeadline = null;
        Boolean expectedDone = false;
        Person expectedCreator = null;

        TodoItem todoItem = new TodoItem(1, "title", "description", null, false, null);
    }
}
