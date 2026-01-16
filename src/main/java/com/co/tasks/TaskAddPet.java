package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.interactions.Post;
import com.co.models.pets.Pet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

/**
 * Task for creating a new pet in the system. This task uses a Pet payload to send a POST request to
 * the "pet" endpoint.
 */
public class TaskAddPet implements Task {

  private final Pet payload;

  /**
   * Constructs a TaskCreateBooking with the specified pet payload.
   *
   * @param payload The {@link Pet} object containing the details for the new pet.
   */
  public TaskAddPet(Pet payload) {
    this.payload = payload;
  }

  /**
   * Creates an instrumented instance of TaskCreateBooking with the provided payload.
   *
   * @param payload The {@link Pet} object to be used as the request body.
   * @return A {@link Performable} task ready to be executed by an {@link Actor}.
   */
  public static Performable withPayload(Pet payload) {
    return instrumented(TaskAddPet.class, payload);
  }

  /**
   * Performs the task of creating a pet as the given actor. The actor attempts to send a POST
   * request with the pet payload.
   *
   * @param actor The {@link Actor} performing the task.
   * @param <T> A type that extends {@link Actor}.
   */
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to("/pet")
            .with(
                requestSpecification ->
                    requestSpecification.contentType(ContentType.JSON).body(payload)));
  }
}
