package workshop.gsd;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {

    @Test
    void getSummary_WithAssignedPerson_ReturnsExpectedSummary() {
        LocalDate deadline = LocalDate.now().plusDays(1);
        Person assignee = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Task Title", deadline,assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

        // Act
        String summary = todoItemTask.getSummary();

        // Assert
        String expected = String.format("TodoItemTask - Details:\n{\n" +
                        "  \"id\": %d,\n" +
                        "  \"assigned\": true,\n" +
                        "  \"todoItem\": %s,\n" +
                        "  \"assignee\": %s\n" +
                        "}",
                todoItemTask.getId(),
                todoItem.getSummary(),
                assignee.getSummary());
        assertEquals(expected, summary);
    }

    @Test
    void getSummary_WithoutAssignedPerson_ReturnsExpectedSummary() {
        // Arrange
        LocalDate deadline = LocalDate.now().plusDays(1);
        Person weesa = new Person("Wee", "Sa", "wwe.sa@example.com");
        TodoItem todoItem = new TodoItem("New item", deadline,weesa);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, null);

        // Act
        String summary = todoItemTask.getSummary();

        // Assert
        String expected = String.format("TodoItemTask - Details:\n{\n" +
                        "  \"id\": %d,\n" +
                        "  \"assigned\": false,\n" +
                        "  \"todoItem\": %s,\n" +
                        "  \"assignee\": none\n" +
                        "}",
                todoItemTask.getId(),
                todoItem.getSummary());
        assertEquals(expected, summary);
    }

    @Test
    void shouldCreateTodoItemTaskWithValidData() {
        // Arrange
        TodoItem todoItem = new TodoItem("Task Title", "Task Description", LocalDate.now().plusDays(1), false, new Person("John", "Doe", "john.doe@example.com"));
        Person assignee = new Person( "Jane", "Doe", "jane.doe@example.com");

        // Act
        TodoItemTask task = new TodoItemTask(todoItem, assignee);

        // Assert
        assertEquals(todoItem, task.getTodoItem());
        assertEquals(assignee, task.getAssignee());
        assertTrue(task.isAssigned());
    }

    @Test
    void shouldThrowExceptionWhenTodoItemIsNull() {
        // Arrange
        Person assignee = new Person( "Jane", "Doe", "jane.doe@example.com");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new TodoItemTask(null, assignee));
    }

    @Test
    void shouldReturnCorrectId() {
        // Arrange
        TodoItem todoItem = new TodoItem("Task Title", "Task Description", LocalDate.now().plusDays(1), false, new Person( "John", "Doe", "john.doe@example.com"));
        TodoItemTask task = new TodoItemTask(todoItem, null);

        // Act
        int id = task.getId();

        // Assert
        assertTrue(id > 0); // Ensure the ID is positive and auto-incremented
    }

    @Test
    void shouldSetTodoItemCorrectly() {
        // Arrange
        TodoItem todoItem1 = new TodoItem("Task Title", "Task Description", LocalDate.now().plusDays(1), false, new Person( "John", "Doe", "john.doe@example.com"));
        TodoItem todoItem2 = new TodoItem("Another Task", "Another Description", LocalDate.now().plusDays(2), false, new Person( "Jane", "Doe", "jane.doe@example.com"));
        TodoItemTask task = new TodoItemTask(todoItem1, null);

        // Act
        task.setTodoItem(todoItem2);

        // Assert
        assertEquals(todoItem2, task.getTodoItem());
    }

    @Test
    void shouldThrowExceptionWhenSettingNullTodoItem() {
        // Arrange
        TodoItem todoItem = new TodoItem("Task Title", "Task Description", LocalDate.now().plusDays(1), false, new Person( "John", "Doe", "john.doe@example.com"));
        TodoItemTask task = new TodoItemTask(todoItem, null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> task.setTodoItem(null));
    }

    @Test
    void shouldReturnCorrectSummary() {
        // Arrange
        TodoItem todoItem = new TodoItem("Task Title", "Task Description", LocalDate.now().plusDays(1), false, new Person( "John", "Doe", "john.doe@example.com"));
        TodoItemTask task = new TodoItemTask(todoItem, null);
        String expectedSummary = String.format("TodoItemTask - Details:\n{\n" +
                "  \"id\": %d,\n" +
                "  \"assigned\": %s,\n" +
                "  \"todoItem\": %s,\n" +
                "  \"assignee\": %s\n" +
                "}", task.getId(), false, todoItem.getSummary(), "none");

        // Act
        String actualSummary = task.getSummary();

        // Assert
        assertEquals(expectedSummary, actualSummary);
    }
}
