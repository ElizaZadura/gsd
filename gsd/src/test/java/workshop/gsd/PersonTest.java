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

    @Test
    void getSummaryShouldReturnFormattedString() {
        // Arrange
        Person person = new Person(1, "Nisse", "Olsson", "nisse@gmail.com");
        String expectedSummary = "{id: 1, name: Nisse Olsson, email: nisse@gmail.com}";

        // Act
        String actualSummary = person.getSummary();

        // Assert
        assertEquals(expectedSummary, actualSummary);
    }

    @Test
    void setFirstNameShouldThrowExceptionForNullValue() {
        // Arrange
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");

        // Act & Assert (combined for clarity, as the action is the assertion)
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(null));
    }
    @Test
void setFirstNameShouldThrowExceptionForInvalidFormat() {
    Person person = new Person(1, "John", "Doe", "john.doe@example.com");
    assertThrows(Person.InvalidNameFormatException.class, () -> person.setFirstName("John123")); // Or IllegalArgumentException
}
@Test
    void setEmailShouldThrowInvalidEmailFormatException(){
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        assertThrows(Person.InvalidEmailFormatException.class, () -> person.setEmail("john.doe@example@com"));
}
}
