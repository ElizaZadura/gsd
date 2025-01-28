package workshop.gsd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void shouldCreatePersonWithCorrectData() {
        // Arrange: Set up the expected values and create a Person object
        int expectedId = 1;
        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        String expectedEmail = "john.doe@example.com";
        Person person = new Person(expectedId, expectedFirstName, expectedLastName, expectedEmail);

        // Act:  No action needed here since we are testing the constructor

        // Assert: Verify the person object's data
        assertEquals(expectedId, person.getId());
        assertEquals(expectedFirstName, person.getFirstName());
        assertEquals(expectedLastName, person.getLastName());
        assertEquals(expectedEmail, person.getEmail());
    }

    // Add more test methods for other Person behaviors
}
