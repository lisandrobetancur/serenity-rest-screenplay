# Serenity REST Screenplay API Testing Framework

This project provides a robust and scalable framework for automated API testing, built with Serenity BDD, the Screenplay pattern, and Maven. It demonstrates how to write clean, maintainable, and business-readable tests for RESTful web services.

The example tests are written for the public PetStore API (https://petstore.swagger.io/).

## Key Technologies

*   **Java**: Core programming language.
*   **Serenity BDD**: An open-source library that helps you write better, more collaborative acceptance tests.
*   **Serenity Screenplay**: A user-centric design pattern for writing high-quality automated tests. It encourages a clean separation of concerns and improves test readability and maintainability.
*   **REST-assured**: A Java DSL for simplifying testing of REST-based services.
*   **Maven**: A powerful project management and comprehension tool.
*   **JUnit**: A simple framework to write repeatable tests.

## Understanding Serenity BDD and the Screenplay Pattern

This framework is built around the **Screenplay Pattern**, an approach to writing acceptance tests that focuses on the user's perspective. It helps create more readable, reusable, and scalable test code. For more details, refer to the [Serenity BDD Screenplay Fundamentals Documentation](https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals). The key components of this pattern are:

-   **Actors**: Represent users or external systems that interact with the application. Each actor has a name and certain `Abilities`.
-   **Abilities**: What an actor *can do*. For example, an actor might have the ability to `CallAnApi` to send REST requests.
-   **Tasks**: High-level actions that an actor *wants to do*. Tasks describe the goal from a user's perspective (e.g., `add a new pet to the store`). They are composed of other tasks or lower-level `Interactions`.
-   **Interactions**: Low-level actions that an actor performs to achieve a task. These are the direct interactions with the application's interface (e.g., clicking a button, or in this case, sending a `POST` request).
-   **Questions**: Used to query the state of the application. Actors ask `Questions` to verify that their actions had the desired effect (e.g., "What is the response status code?").

**Serenity BDD** integrates seamlessly with this pattern. It uses the descriptive names of your Tasks, Interactions, and Questions to generate rich, narrative-style test reports. This "living documentation" is easy for the whole team to read and understand, bridging the gap between technical and business stakeholders.

## Getting Started

### Prerequisites

*   Java JDK 11 or higher
*   Apache Maven

### Running the Tests

To execute the tests, run the following Maven command from the project root directory:

```bash
mvn clean verify
```

This command will compile the project, run the tests, and generate a comprehensive Serenity report in the `target/site/serenity/` directory.

### Serenity Report

After the test execution, you can open the `index.html` file located in `target/site/serenity/` in your web browser to view a detailed report of the test results. The report provides a living documentation of your application's features.

## Project Structure

The project follows the standard Maven directory layout. The core framework components are organized as follows:

-   `src/main/java/com/co/`:
    -   `interactions`: Custom Serenity Screenplay interactions (e.g., `Get`, `Post`, `Put`, `Delete`).
    -   `models`: POJO (Plain Old Java Object) classes representing the data entities of the API (e.g., `Pet`, `Category`).
    -   `questions`: Serenity Screenplay Questions to query the state of the application or the response from the API.
    -   `tasks`: Serenity Screenplay Tasks that represent the actions a user performs.
    -   `utils`: Utility classes.
-   `src/test/java/com/co/`:
    -   `base`: Base test setup and configuration.
    -   `runners` or `booking/runner`: Test runners (e.g., JUnit classes) that execute the feature files or test scenarios.

This structure separates the "what" (tasks) from the "how" (interactions), promoting reusable components and making the tests easier to read and maintain.

