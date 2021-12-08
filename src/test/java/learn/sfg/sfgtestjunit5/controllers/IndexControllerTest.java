package learn.sfg.sfgtestjunit5.controllers;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index(), "Wrong View Returned");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
//        assertEquals("notimplemented", controller.oupsHandler(), this::makeExpensiveMessage);
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandler();
        });
    }

    @Disabled("Demo of timeout that should fail")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Disabled("Demo of timeout that should fail")
    @Test
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Test
    void testAssumptionTrue() {
        Assumptions.assumeTrue("sfg".equalsIgnoreCase(System.getenv("SFG_RUNTIME")));
    }

    private String makeExpensiveMessage() {
        return "This is some expensive " + makeRandom() + " "
                + "Message to build " + makeRandom() + " "
                + "for my test. " + makeRandom() + " "
                + "Make me only if you have to.";
    }

    private int makeRandom() {
        Random rnd = new Random();
        System.out.println("Making Random Integer Value");
        return rnd.nextInt(100);
    }
}
