package workshop.gsd;

import java.util.concurrent.atomic.AtomicInteger;

/**
  * Represents a task associated with a TodoItem, potentially assigned to a Person.
  * This class manages the assignment and provides a summary of the task.
  */
 public class TodoItemTask {
     //  A static atomic integer to generate unique IDs for each task.
     private static final AtomicInteger nextId = new AtomicInteger(1);
     //  The unique identifier for the task.
     private final int id;
     //  A flag indicating whether the task has been assigned to a person.
     private boolean assigned;
     //  The TodoItem associated with this task.
     private TodoItem todoItem;
     //  The Person assigned to this task (can be null if not assigned).
     private Person assignee;

     /**
      * Constructs a TodoItemTask object.
      *
      * @param todoItem The TodoItem associated with this task. Must not be null.
      * @param assignee The Person assigned to this task. Can be null.
      * @throws IllegalArgumentException If todoItem is null.
      */
     public TodoItemTask(TodoItem todoItem, Person assignee) {
         if (todoItem == null) {
             throw new IllegalArgumentException("TodoItem cannot be null.");
         }
         this.id = nextId.getAndIncrement();
         this.todoItem = todoItem;
         this.assignee = assignee;
         this.assigned = assignee != null;
     }

     // Getters and Setters
     /**
      * Returns the unique identifier of the task.
      * @return The task ID.
      */
     public int getId() {
         return id;
     }

     /**
      * Checks if the task is currently assigned to a person.
      * @return True if the task is assigned, false otherwise.
      */
     public boolean isAssigned() {
         return assigned;
     }

     /**
      * Returns the TodoItem associated with this task.
      * @return The TodoItem.
      */
     public TodoItem getTodoItem() {
         return todoItem;
     }

     /**
      * Sets the TodoItem associated with this task.
      * @param todoItem The new TodoItem. Must not be null.
      * @throws IllegalArgumentException If todoItem is null.
      */
     public void setTodoItem(TodoItem todoItem) {
         if (todoItem == null) {
             throw new IllegalArgumentException("TodoItem cannot be null.");
         }
         this.todoItem = todoItem;
     }

     /**
      * Returns the Person assigned to this task.
      * @return The assignee, or null if no one is assigned.
      */
     public Person getAssignee() {
         return assignee;
     }

     /**
      * Assigns a Person to this task.
      * @param assignee The Person to assign, or null to unassign.
      */
     public void setAssignee(Person assignee) {
         this.assignee = assignee;
         this.assigned = assignee != null;
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

     public String getShortSummary() {
         return String.format("{id: %d, assigned: %s, todoItem: %s, assignee: %s %s}", id, assigned, todoItem.getTitle(), assignee.getFirstName(), assignee.getLastName());
     }
 }
