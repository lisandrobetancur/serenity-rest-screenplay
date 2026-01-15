package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.interactions.Get;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

/**
 * A Serenity BDD Task to retrieve pets by their status via a GET request to the "pet/findByStatus"
 * endpoint.
 */
public class TaskFindPets implements Task {

  private final String status;

  /**
   * Constructs a TaskFindPets with the specified status.
   *
   * @param status The status of the pet to retrieve.
   */
  public TaskFindPets(String status) {
    this.status = status;
  }

  /**
   * Static factory method to create an instrumented instance of TaskFindPets.
   *
   * @param status The status of the pets to retrieve.
   * @return An instrumented Performable task to get pets by status.
   */
  public static Performable byStatus(String status) {
    return instrumented(TaskFindPets.class, status);
  }

  /**
   * Performs the task of retrieving pets by status as the given actor.
   *
   * @param actor The actor performing the action.
   * @param <T> The type of the actor.
   */
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.to("/pet/findByStatus")
            .with(request -> request.queryParam("status", status).contentType(ContentType.JSON)));
  }
}
