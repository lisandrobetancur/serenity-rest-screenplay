package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.models.bookings.Booking;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class TaskCreateBooking implements Task {

  private final Booking payload;

  public TaskCreateBooking(Booking payload) {
    this.payload = payload;
  }

  public static Performable withPayload(Booking payload) {
    return instrumented(TaskCreateBooking.class, payload);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to("booking")
            .with(
                requestSpecification ->
                    requestSpecification.contentType(ContentType.JSON).body(payload)));
  }
}
