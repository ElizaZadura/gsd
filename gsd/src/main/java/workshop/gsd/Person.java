package workshop.gsd;

import java.util.UUID;

public class Person {
    private final UUID id;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructs a Person object.
     * Since none of the attributes are allowed to be null, as per assignment instructions, it's not necessary to have more than the default constructor, with 3 parameters and an autogenerated ID
     *
     * @param id        The ID of the person, autogenerated
     * @param firstName The first name of the person. Must not be null.
     * @param lastName  The last name of the person. Must not be null.
     * @param email     The email address of the person. Must not be null.
     * @throws IllegalArgumentException If firstName, lastName, or email is null, or firstName/lastName contains invalid characters, or the email has an incorrect format
     */
    public Person(String firstName, String lastName, String email) {
        // Input validation:
        if (firstName == null || lastName == null || email == null) {
            throw new IllegalArgumentException("First name, last name, and email cannot be null.");
        } else if (!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")) {
            throw new InvalidNameFormatException("First and last name must contain only letters.");
        } else if (!isValidEmail(email)) {
            throw new InvalidEmailFormatException("Invalid email format!");
        }
        //TODO: autogenerate ID instead of taking it as a parameter
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null.");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new InvalidEmailFormatException("Invalid email format!");
        }
        this.email = email;
    }

    /**
     * Returns a summary description of the Person object.
     *
     * @return A string in the format "{id: 4, name: Nisse Olsson, email: nisse@gmail.com}".
     * TODO: change name
     */
    //in this case, using String.format seems preferable, due to readability, and it also ensures correct data types are used for formatting
    public String getSummary() {
        return String.format("{id: %s, name: %s %s, email: %s}", id, firstName, lastName, email);
    }

    // Custom Exception for invalid name format
    static class InvalidNameFormatException extends IllegalArgumentException {
        public InvalidNameFormatException(String message) {
            super(message);
        }
    }
    static class InvalidEmailFormatException extends IllegalArgumentException {
        public InvalidEmailFormatException(String message) {
            super(message);
        }
    }
    private boolean isValidEmail(String email) {
        // Using simple regex, can be extended to use more complex checks...
        return email.matches(".+@.+\\..+");
    }
}
