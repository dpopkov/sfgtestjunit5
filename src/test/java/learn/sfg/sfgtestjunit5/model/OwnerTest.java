package learn.sfg.sfgtestjunit5.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Jane", "Doe");
        owner.setCity("Key East");
        owner.setTelephone("1234123123");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Jane", owner.getFirstName(), "First name did not match"),
                        () -> assertEquals("Doe", owner.getLastName(), "Last name did not math")
                ),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key East", owner.getCity(), "City did not match"),
                        () -> assertEquals("1234123123", owner.getTelephone(), "Telephone did not match")
                )
        );
    }
}
