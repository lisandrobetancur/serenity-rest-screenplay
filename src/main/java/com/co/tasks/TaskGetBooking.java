package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

/**
 * A Serenity BDD Task to retrieve a booking by its ID via a GET request to the "/booking/{id}"
 * endpoint.
 */
public class TaskGetBooking implements Task {

  private final int id;

  /**
   * Constructs a GetBookingTask with the specified booking ID.
   *
   * @param id The ID of the booking to retrieve.
   */
  public TaskGetBooking(int id) {
    this.id = id;
  }

  /**
   * Static factory method to create an instrumented instance of GetBookingTask.
   *
   * @param id The ID of the booking to retrieve.
   * @return An instrumented Performable task to get a booking by ID.
   */
  public static Performable byId(int id) {
    return instrumented(TaskGetBooking.class, id);
  }

  /**
   * Performs the task of retrieving a booking by ID as the given actor.
   *
   * @param actor The actor performing the action.
   * @param <T> The type of the actor.
   */
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.resource("booking/" + id)
            .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)));
  }
}
