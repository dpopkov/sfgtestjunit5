[![CircleCI](https://circleci.com/gh/dpopkov/sfgtestjunit5/tree/main.svg?style=svg)](https://circleci.com/gh/dpopkov/sfgtestjunit5/tree/main)

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
* JUnit extensions
* Test Execution
    * Maven Failsafe Plugin [Configuration](#maven-failsafe-plugin-configuration)
        * run `mvn clean verify`
    * Maven Surefire Test Reporting [Configuration](#maven-surefire-test-reporting-configuration)
        * run `mvn clean site`
    * Executing tests with Tags in Maven
        * `<configuration><groups>controllers</groups></configuration>`

### Maven Failsafe Plugin configuration
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-failsafe-plugin</artifactId>
    <version>2.22.2</version>
    <executions>
        <execution>
            <goals>
                <goal>integration-test</goal>
                <goal>verify</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
### Maven Surefire Test Reporting Configuration
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-site-plugin</artifactId>
            <version>3.8.2</version>    <!-- Upgrading version -->
        </plugin>
    </plugins>
</build>
<reporting>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-report-plugin</artifactId>
            <version>2.22.2</version>
        </plugin>
    </plugins>
</reporting>
```
