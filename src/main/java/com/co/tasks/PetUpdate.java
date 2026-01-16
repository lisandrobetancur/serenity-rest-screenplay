package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.interactions.Put;
import com.co.models.pets.Pet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

/** A Serenity Screenplay task to fully update an existing pet using a PUT request. */
public class PetUpdate implements Task {

  private final Pet payload;

  /**
   * Constructor for the PetUpdate task.
   *
   * @param payload The {@link Pet} object containing the updated pet data.
   */
  public PetUpdate(Pet payload) {
    this.payload = payload;
  }

  /**
   * Creates a new instance of the PetUpdate task.
   *
   * @param payload The {@link Pet} object containing the updated pet data.
   * @return A Performable task to update the pet.
   */
  public static Performable withPayload(Pet payload) {
    return instrumented(PetUpdate.class, payload);
  }

  /**
   * Performs the action of updating a pet.
   *
   * @param actor The actor performing the action.
   * @param <T> The type of the actor.
   */
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Put.to("/pet")
            .with(
                requestSpecification ->
                    requestSpecification.contentType(ContentType.JSON).body(payload)));
  }
}
