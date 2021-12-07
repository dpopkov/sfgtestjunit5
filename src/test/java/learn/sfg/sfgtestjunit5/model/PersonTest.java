package learn.sfg.sfgtestjunit5.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
