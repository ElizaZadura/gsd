package workshop.gsd;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructs a Person object. Since none of the attributes are allowed to be null, it's not necessary to have more than the default constructor, with all 4 parameters
     *
     * @param id        The ID of the person.
     * @param firstName The first name of the person. Must not be null.
     * @param lastName  The last name of the person. Must not be null.
     * @param email     The email address of the person. Must not be null.
     * @throws IllegalArgumentException If firstName, lastName, or email is null.
     */
    public Person(int id, String firstName, String lastName, String email) {
        // Input validation: Ensure required fields are not null
        if (firstName == null || lastName == null || email == null) {
            throw new IllegalArgumentException("First name, last name, and email cannot be null.");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }
        this.email = email;
    }

    /**
     * Returns a summary description of the Person object.
     *
     * @return A string in the format "{id: 4, name: Nisse Olsson, email: nisse@gmail.com}".
     * TODO: change name
     */
    public String getSummary() {
        return String.format("{id: %d, name: %s %s, email: %s}", id, firstName, lastName, email);
    }
}
