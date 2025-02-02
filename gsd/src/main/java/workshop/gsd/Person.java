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
     * The ID of the person, autogenerated
     * @param firstName The first name of the person. Must not be null.
     * @param lastName  The last name of the person. Must not be null.
     * @param email     The email address of the person. Must not be null.
     * @throws IllegalArgumentException If firstName, lastName, or email is null, or firstName/lastName contains invalid characters, or the email has an incorrect format
     */
    public Person(String firstName, String lastName, String email) {
        validateName(firstName);
        validateName(lastName);
        validateEmail(email);

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
/**
     * Returns a summary description of the Person object, formatted for better readability, including a title.
     *
     * @return A formatted string with a title and person details including id, full name, and email.
     */
    public String getSummary() {
        return String.format("Person - Details:\n{\n" +
                "  \"id\": %s,\n" +
                "  \"name\": \"%s %s\",\n" +
                "  \"email\": \"%s\"\n" +
                "}", id, firstName, lastName, email);
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
    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        } else if (!name.matches("[a-zA-Z]+")) {
            throw new InvalidNameFormatException("Name must contain only letters.");
        }
    }
    private void validateEmail(String email) {
        // Using simple regex, can be extended to use more complex checks...
        if (!email.matches(".+@.+\\..+"))
        {
            throw new InvalidEmailFormatException("Invalid email format!");
        }
    }
}
