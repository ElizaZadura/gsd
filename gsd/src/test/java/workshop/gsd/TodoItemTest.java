package workshop.gsd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TodoItemTest {
    private static final String CUSTOM_PATTERN = "yyyy-MM-dd";
    @Test
    void shouldCreateTodoItemWithCorrectData() {
        // Arrange
        Person creator = new Person("Stefan", "Dear", "st.dea@example.com");
        String title = "Finish assignment";
        String description = "Programming workshop 1";
        LocalDate deadline = LocalDate.now().plusDays(2);
        boolean done = false;

        // Act
        TodoItem todoItem = new TodoItem(title, description, deadline, done, creator);

        // Assert
        assertEquals(title, todoItem.getTitle());
        assertEquals(description, todoItem.getDescription());
        assertEquals(deadline, todoItem.getDeadLine());
        assertFalse(todoItem.isDone());
        assertEquals(creator, todoItem.getCreator());
    }

    @Test
    void shouldThrowExceptionForNullTitle() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new TodoItem(null, "Some description", LocalDate.now().plusDays(1), false, creator);
        });
    }

    @Test
    void shouldThrowExceptionForEmptyTitle() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new TodoItem("", "Some description", LocalDate.now().plusDays(1), false, creator);
        });
    }

    @Test
    void shouldThrowExceptionForNullDeadline() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new TodoItem("Valid Title", "Some description", null, false, creator);
        });
    }

    @Test
    void shouldThrowExceptionForNullCreator() {
        // Arrange
        LocalDate deadline = LocalDate.now().plusDays(1);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new TodoItem("Valid Title", "Some description", deadline, false, null);
        });
    }

    @Test
    void getSummaryShouldReturnFormattedString() {
        // Arrange
        Person creator = new Person( "Marvin", "Bot", "marv@bot.com"); // Create a Person object as the creator
        TodoItem todoItem = new TodoItem("My task", "Needs to get done", LocalDate.now().plusDays(1), false, creator);
        UUID actualId = todoItem.getId(); // Get the actual generated UUID
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CUSTOM_PATTERN);
        String expectedSummary = String.format("TodoItem - Details:\n{\n" +
                        "  \"id\": \"%s\",\n" +
                        "  \"title\": \"%s\",\n" +
                        "  \"description\": \"%s\",\n" +
                        "  \"deadline\": \"%s\",\n" +
                        "  \"done\": %s,\n" +
                        "  \"creator\": %s\n" +
                        "}", actualId.toString(), "My task", "Needs to get done",
                LocalDate.now().plusDays(1).format(formatter), false, creator.getSummary());

        // Act
        String actualSummary = todoItem.getSummary();

        // Assert
        assertEquals(expectedSummary, actualSummary);
    }

    @Test
    void isOverdueShouldReturnFalseForFutureDeadline() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Task", "Description", LocalDate.now().plusDays(1), false, creator);

        // Act
        boolean isOverdue = todoItem.isOverdue();

        // Assert
        assertFalse(isOverdue);
    }

    @Test
    void isOverdueShouldReturnFalseForTodayDeadline() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Task", "Description", LocalDate.now(), false, creator);

        // Act
        boolean isOverdue = todoItem.isOverdue();

        // Assert
        assertFalse(isOverdue);
    }

    @Test
    void setTitleShouldUpdateTitleForValidInput() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Initial Title", "Description", LocalDate.now().plusDays(1), false, creator);
        String newTitle = "Updated Title";

        // Act
        todoItem.setTitle(newTitle);

        // Assert
        assertEquals(newTitle, todoItem.getTitle());
    }

    @Test
    void setTitleShouldThrowExceptionForNullValue() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Initial Title", "Description", LocalDate.now().plusDays(1), false, creator);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> todoItem.setTitle(null));
    }

    @Test
    void setTitleShouldThrowExceptionForEmptyValue() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Initial Title", "Description", LocalDate.now().plusDays(1), false, creator);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> todoItem.setTitle(""));
    }

    @Test
    void setDeadLineShouldThrowExceptionForNullValue() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Task", "Description", LocalDate.now().plusDays(1), false, creator);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> todoItem.setDeadLine(null));
    }

    @Test
    void setDeadLineShouldThrowExceptionForPastDate() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Task", "Description", LocalDate.now().plusDays(1), false, creator);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> todoItem.setDeadLine(LocalDate.now().minusDays(1)));
    }

    @Test
    void setCreatorShouldThrowExceptionForNullValue() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Task", "Description", LocalDate.now().plusDays(1), false, creator);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> todoItem.setCreator(null));
    }

    @Test
    void shouldCreateTodoItemWithTitleDeadlineAndCreator() {
        // Arrange
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        String title = "Buy groceries";
        LocalDate deadline = LocalDate.now().plusDays(5);

        // Act
        TodoItem todoItem = new TodoItem(title, deadline, creator);

        // Assert
        assertEquals(title, todoItem.getTitle());
        assertNull(todoItem.getDescription()); // Assuming description is null by default
        assertEquals(deadline, todoItem.getDeadLine());
        assertFalse(todoItem.isDone());
        assertEquals(creator, todoItem.getCreator());
    }

}
