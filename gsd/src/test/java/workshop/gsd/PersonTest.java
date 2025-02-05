package workshop.gsd;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
    void shouldCreatePersonWithCorrectData() {
        // Arrange: Set up the expected values and create a Person object

        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        String expectedEmail = "john.doe@example.com";
        Person person = new Person(expectedFirstName, expectedLastName, expectedEmail);
        UUID expectedId = person.getId();

        assertEquals(expectedId, person.getId());
        assertEquals(expectedFirstName, person.getFirstName());
        assertEquals(expectedLastName, person.getLastName());
        assertEquals(expectedEmail, person.getEmail());
    }

    @Test
    void toStringShouldReturnFormattedString() {
        // Arrange
        Person person = new Person("Boo", "Hamster", "boolikes@theforest.com");
        String expectedString = String.format("{id: %s, name: %s %s, email: %s}",
                person.getId(), person.getFirstName(),
                person.getLastName(), person.getEmail());

        // Act
        String actualString = person.toString();

        // Assert
        assertEquals(expectedString, actualString);
    }
    @Test
    void setFirstNameShouldThrowExceptionForNullValue() {
        // Arrange
        Person person = new Person("John", "Doe", "john.doe@example.com");

        // Act & Assert (combined for clarity, as the action is the assertion)
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(null));
    }
    @Test
void setFirstNameShouldThrowExceptionForInvalidFormat() {
    Person person = new Person("Stefan", "Gnafs", "s.gn@ex.com");
    assertThrows(Person.InvalidNameFormatException.class, () -> person.setFirstName("John123")); // Or IllegalArgumentException
}
@Test
    void setEmailShouldThrowInvalidEmailFormatException(){
        Person person = new Person("Monkey", "Mankey", "mon.ma@example.com");
        assertThrows(Person.InvalidEmailFormatException.class, () -> person.setEmail("john.doe@example@com"));
}
}
