package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.models.bookings.Booking;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

/**
 * Task for creating a new booking in the system.
 * This task uses a Booking payload to send a POST request to the "booking" endpoint.
 */
public class TaskCreateBooking implements Task {

  private final Booking payload;

  /**
   * Constructs a TaskCreateBooking with the specified booking payload.
   *
   * @param payload The {@link Booking} object containing the details for the new booking.
   */
  public TaskCreateBooking(Booking payload) {
    this.payload = payload;
  }

  /**
   * Creates an instrumented instance of TaskCreateBooking with the provided payload.
   *
   * @param payload The {@link Booking} object to be used as the request body.
   * @return A {@link Performable} task ready to be executed by an {@link Actor}.
   */
  public static Performable withPayload(Booking payload) {
    return instrumented(TaskCreateBooking.class, payload);
  }

  /**
   * Performs the task of creating a booking as the given actor.
   * The actor attempts to send a POST request with the booking payload.
   *
   * @param actor The {@link Actor} performing the task.
   * @param <T> A type that extends {@link Actor}.
   */
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to("booking")
            .with(
                requestSpecification ->
                    requestSpecification.contentType(ContentType.JSON).body(payload)));
  }
}
