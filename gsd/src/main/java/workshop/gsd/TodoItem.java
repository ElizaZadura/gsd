package workshop.gsd;

import java.time.LocalDate;
import java.util.UUID;

public class TodoItem {
    private final UUID id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    /**
     * Constructs a TodoItem object.
     *
     * @param title       Must not be null or empty.
     * @param description   Describes it
     * @param deadLine    The deadline
     * @param done        Is complete
     * @param creator    The creator
     * @throws IllegalArgumentException If title is null or empty, or if deadline or creator is null.
     */
    public TodoItem(String title, String description, LocalDate deadLine, boolean done, Person creator) {
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
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
        this.creator = creator;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
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
        if (deadLine == null || deadLine.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Deadline can't be empty, and backdating not allowed");
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
        return String.format("{id: %s, title: %s, description: %s, deadline: %s, done: %s, creator: %s}",
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
