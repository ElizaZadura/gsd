package workshop.gsd;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    /**
     * Constructs a TodoItemTask object.
     *
     * @param id        The ID of the task.
     * @param todoItem The TodoItem associated with this task. Must not be null.
     * @param assignee The Person assigned to this task. Can be null.
     * @throws IllegalArgumentException If todoItem is null.
     */
    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        // Input validation: Ensure required fields are not null
        if (todoItem == null) {
            throw new IllegalArgumentException("TodoItem cannot be null.");
        }
        this.id = id;
        this.todoItem = todoItem;
        this.assignee = assignee;
        this.assigned = assignee != null; // Set 'assigned' based on assignee
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null) {
            throw new IllegalArgumentException("TodoItem cannot be null.");
        }
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = assignee != null; // Update 'assigned' when assignee is set
    }

    /**
     * Returns a summary description of the TodoItemTask object.
     *
     * @return A string in the format "{id: 1, assigned: true, todoItem: ..., assignee: ...}".
     */
    public String getSummary() {
        return String.format("{id: %d, assigned: %s, todoItem: %s, assignee: %s}",
                id, assigned, todoItem.getSummary(), assignee != null ? assignee.getSummary() : "none");
    }
}
