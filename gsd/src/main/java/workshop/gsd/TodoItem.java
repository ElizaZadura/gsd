package workshop.gsd;

import java.time.LocalDate;

public class TodoItem {
    private int id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    /**
     * Constructs a TodoItem object.
     *
     * @param id          The ID of the todo item.
     * @param title       The title of the todo item. Must not be null or empty.
     * @param description A description of the todo item. Can be null.
     * @param deadLine    The deadline of the todo item. Must not be null.
     * @param done        Indicates if the todo item is done.
     * @param creator    The person who created this todo item. Must not be null.
     * @throws IllegalArgumentException If title is null or empty, or if deadline or creator is null.
     */
    public TodoItem(int id, String title, String description, LocalDate deadLine, boolean done, Person creator) {
        // Input validation: Ensure required fields are not null or empty
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (deadLine == null) {
            throw new IllegalArgumentException("Deadline cannot be null.");
        }
        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null.");
        }
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
        this.creator = creator;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null) {
            throw new IllegalArgumentException("Deadline cannot be null.");
        }
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null.");
        }
        this.creator = creator;
    }

    /**
     * Returns a summary description of the TodoItem object.
     *
     * @return A string in the format "{id: 1, title: Make lunch, description: ..., deadline: 2025-01-31, done: false, creator: ...}".
     */
    public String getSummary() {
        return String.format("{id: %d, title: %s, description: %s, deadline: %s, done: %s, creator: %s}",
                id, title, description, deadLine, done, creator.getSummary());
    }

    /**
     * Checks if the todo item is overdue.
     *
     * @return True if the current date is after the deadline, false otherwise.
     */
    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadLine);
    }
}
