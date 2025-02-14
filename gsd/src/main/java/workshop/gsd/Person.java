package workshop.gsd;

import java.util.UUID;

public class Person {
    private final UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    /**
     * Constructs a Person object.
     * @param firstName The first name of the person. Must not be null.
     * @param lastName  The last name of the person. Must not be null.
     * @param email     The email address of the person. Must not be null.
     * @throws IllegalArgumentException If firstName, lastName, or email is null, or firstName/lastName contains invalid characters, or the email has an incorrect format
     */
    public Person(String firstName, String lastName, String email) {
        //todo: it doesn't add value in this case to use custom exceptions, refactoring needed!
        validateName(firstName);
        validateName(lastName);
        validateEmail(email);

        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
 * Constructs a new Person object with the specified first name, last name, email, and credentials.
 *
 * @param firstName the first name of the person
 * @param lastName  the last name of the person
 * @param email     the email address of the person
 * @param credentials the AppUser object containing the person's credentials
 */
public Person(String firstName, String lastName, String email, AppUser credentials) {
    this(firstName, lastName, email);
    this.credentials = credentials;
}
    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateName(lastName);
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }
    public AppUser getCredentials() {
        return credentials;
    }
    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }
    @Override
    public String toString() {
        return String.format("{id: %s, name: %s %s, email: %s}", id, firstName, lastName, email);
    }
    //todo: use existing exc?
    /**
 * Custom Exception for invalid name format.
 * This exception is thrown when a name does not conform to the expected format.
 */
static class InvalidNameFormatException extends IllegalArgumentException {
    /**
     * Constructs a new InvalidNameFormatException with the specified detail message.
     *
     * @param message the detail message which is saved for later retrieval by the
     *                {@link Throwable#getMessage()} method.
     */
    public InvalidNameFormatException(String message) {
        super(message);
    }
}
    /**
 * Custom Exception for invalid email format.
 * This exception is thrown when an email does not conform to the expected format.
 */
static class InvalidEmailFormatException extends IllegalArgumentException {
    /**
     * Constructs a new InvalidEmailFormatException with the specified detail message.
     *
     * @param message the detail message which is saved for later retrieval by the
     *                {@link Throwable#getMessage()} method.
     */
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
    /**
 * Validates the given name.
 *
 * @param name the name to validate
 * @throws IllegalArgumentException if the name is null
 * @throws InvalidNameFormatException if the name does not contain only letters
 */
private void validateName(String name) {
    if (name == null) {
        throw new IllegalArgumentException("Name cannot be null.");
    } else if (!name.matches("[a-zA-Z]+")) {
        throw new InvalidNameFormatException("Name must contain only letters.");
    }
}
    /**
 * Validates the given email.
 *
 * @param email the email to validate
 * @throws InvalidEmailFormatException if the email does not conform to the expected format
 */
private void validateEmail(String email) {
    // Using simple regex, can be extended to use more complex checks...
    if (!email.matches(".+@.+\\..+"))
    {
        throw new InvalidEmailFormatException("Invalid email format!");
    }
}
}
