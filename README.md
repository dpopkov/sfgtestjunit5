# Testing Java with JUnit 5

* Assertions with failure messages
* Grouped and Dependent Assertions
* Skipping tests
* Display test names
* Testing expected exceptions
* Testing timeouts
* Assumptions
* Conditional test execution
* Using AssertJ
* Using Hamcrest
* Tagging and Filtering Tests
    * Edit configurations -> add JUNit config -> Test kind: Tags -> Tag expression
* Nested tests
* Using tagged test interfaces
    * Create interface annotated with @Tag
    * Add the annotated interface it as a marker to test classes
* Using default test methods
    * Create default method in test interface
    * Use @org.junit.jupiter.api.TestInstance annotation
* Repeating tests
* JUnit5 dependency injection in tests
    * Parameter Resolver API - allows to inject parameters into test methods
    * 3 built-in resolvers:
        * TestInfo
        * RepetitionInfo
        * TestReporter
* Parameterized tests
    * Value Source
    * Enum Source
    * CSV Source
    * CSV File Source
    * Method Provider
    * Custom Provider
