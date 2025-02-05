package workshop.gsd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {


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
    void toStringShouldReturnFormattedString() {
        // Arrange
        Person assignee = new Person("Giania", "Doh", "gee.do@example.com");
        TodoItem todoItem = new TodoItem("Task Title", "Task Description", LocalDate.now().plusDays(1), false, new Person("John", "Doe", "john.doe@example.com"));
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);
        String expectedString = String.format("{id: %d, assigned: %s, todoItem: %s}",
                todoItemTask.getId(), todoItemTask.isAssigned(), todoItem.toString());

        // Act
        String actualString = todoItemTask.toString();

        // Assert
        assertEquals(expectedString, actualString);
    }
}
