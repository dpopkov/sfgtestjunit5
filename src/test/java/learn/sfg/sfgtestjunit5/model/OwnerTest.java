package learn.sfg.sfgtestjunit5.model;

import learn.sfg.sfgtestjunit5.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

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

    @Test
    void testUsingHamcrest() {
        Owner owner = new Owner(1L, "Jane", "Doe");
        owner.setCity("Key East");
        assertThat(owner.getCity(), is("Key East"));
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] : {argumentsWithNames}")
    @ValueSource(strings = {"Spring", "Framework", "Genius"})
    void testValueSource(String value) {
        System.out.println("value = " + value);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] : {argumentsWithNames}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println("ownerType = " + ownerType);
    }

    @DisplayName("CSV Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] : {argumentsWithNames}")
    @CsvSource(value = {
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 1, 3"})
    void csvTest(String stateName, int value1, int value2) {
        System.out.printf("stateName=%s, value1=%d, value2=%d%n", stateName, value1, value2);
    }

    @DisplayName("CSV from File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] : {argumentsWithNames}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String state, int value1, int value2) {
        System.out.printf("state=%s, value1=%d, value2=%d%n", state, value1, value2);
    }
}
