package learn.sfg.sfgtestjunit5.model;

import learn.sfg.sfgtestjunit5.ModelTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

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
