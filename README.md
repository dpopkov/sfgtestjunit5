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
