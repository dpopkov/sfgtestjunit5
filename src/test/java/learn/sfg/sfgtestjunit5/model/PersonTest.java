package learn.sfg.sfgtestjunit5.model;

import learn.sfg.sfgtestjunit5.ModelTests;
import org.junit.jupiter.api.*;

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

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition}/{totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDi(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    interface RepeatedTestInfoMarker {
        @BeforeEach
        default void beforeEachDisplayTestInfo(TestInfo testInfo, RepetitionInfo repetitionInfo) {
            System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
        }
    }

    @DisplayName("Person Assignment Nested Test - ")
    @Nested
    class PersonNestedTest implements RepeatedTestInfoMarker {

        @DisplayName("Assignment Nested Repeated Test")
        @RepeatedTest(value = 3, name = "{currentRepetition} {displayName} of {totalRepetitions}")
        void myNestedRepeatedTest() {
            System.out.println("inside myNestedRepeatedTest()");
        }
    }
}
