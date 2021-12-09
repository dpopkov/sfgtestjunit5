package learn.sfg.sfgtestjunit5.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Tag("controllers")
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

        // Using AssertJ
        assertThat(controller.index())
                .startsWith("ind")
                .endsWith("ex")
                .isEqualTo("index");
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

    @Test
    @EnabledOnOs(OS.LINUX)
    void testMeOnLinux() {
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeOnJava11() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testMeOnJava17() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SFG_RUNTIME", matches = "sfg")
    void testMeIfEnvironmentVariable() {
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
