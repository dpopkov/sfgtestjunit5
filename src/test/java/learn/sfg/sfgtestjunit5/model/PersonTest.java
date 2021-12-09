package learn.sfg.sfgtestjunit5.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Jane", "Doe");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Jane", person.getFirstName(), "First name failed"),
                () -> assertEquals("Doe", person.getLastName(), "Last name failed"));
    }
}
