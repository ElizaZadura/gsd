package workshop.gsd;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TodoItem {

    static final String CUSTOM_PATTERN = "yyyy-MM-dd";
    static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(CUSTOM_PATTERN);
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
     */
    public TodoItem( String title, String description, LocalDate deadLine, boolean done, Person creator) {

        validateStrings(title);
        checkDateFormat(deadLine);
        checkCreator(creator);

        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
        this.creator = creator;
        this.id = UUID.randomUUID();
    }

    /**
     * Constructs a TodoItem object.
     *
     * @param title       Must not be null or empty.
     * @param deadLine    The deadline
     * @param creator    The creator
     * @throws IllegalArgumentException if the title is null or empty, if the deadline is null or before today or if the creator is null.
     */
    public TodoItem(String title, LocalDate deadLine, Person creator) {
        this(title, null, deadLine, false, creator);
    }
    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateStrings(title);
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
        checkDateFormat(deadLine);
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
    @Override
    public String toString() {
        return String.format("{id: %s, title: %s, description: %s, deadline: %s, done: %s}",
                id, title, description, deadLine, done);
    }
    /**
     * Checks if the item is overdue.
     *
     * @return True if the current date is after the deadline, false otherwise.
     */
    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadLine);
    }

    static class InvalidNameFormatException extends IllegalArgumentException {
        public InvalidNameFormatException(String message) {
            super(message);
        }
    }
    static class InvalidLocalDateException extends DateTimeException {
        public InvalidLocalDateException(String message) {
            super(message);
        }
    }
    private void validateStrings(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Enter an acceptable value.");
        //allowed: alphanumeric, spaces, not allowed only spaces or special characters
        } else if (!title.matches("^(.|\\s)*[a-zA-Z]+(.|\\s)*$")) {
            throw new TodoItem.InvalidNameFormatException("Write some proper text...");
        }
    }

    private void checkDateFormat(LocalDate deadline) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CUSTOM_PATTERN);
        dateFormat.setLenient(false);
        if (deadline == null) {
            throw new IllegalArgumentException("Please enter a date in the format \"2000-01-01\"");
        } else if (deadline.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The deadline cannot be set to an earlier date");
        }
    }

    private void checkCreator(Person creator) {
        if (creator == null) {
            throw new IllegalArgumentException("The creator has to be a person.");
        }
    }
    public static LocalDate isValidLocalDate(String dateStr, DateTimeFormatter dateFormatter) {

        LocalDate date = null;
        try {
            date = LocalDate.parse(dateStr, dateFormatter);
        } catch (InvalidLocalDateException e) {
            throw new InvalidLocalDateException("It's not possible to parse the value you entered as a date!");
        }
        return date;
    }
}
