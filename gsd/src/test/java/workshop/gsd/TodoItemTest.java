package workshop.gsd;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoItemTest {
    @Test
    void shouldCreateTodoItemWithCorrectData() {
        UUID expectedId = UUID.randomUUID();
        Person creator = new Person("Marvin", "Bot", "marv@bot.com");
        LocalDate today = LocalDate.now();

        String expectedTitle = "One";
        String expectedDescription = "this has to be done";
        Boolean expectedDone = false;

        TodoItem todoItem = new TodoItem("title", "description", null, false, null);

        // Assert: Verify the person object's data
        assertEquals(expectedId, creator.getId());
        assertEquals(expectedDescription, todoItem.getDescription());
        assertEquals(today, todoItem.getDeadLine());
    }
}
