package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.interactions.Post;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

/** A Serenity Screenplay task to perform a partial update on a pet using a POST request. */
public class PartialPetUpdate implements Task {

  private final Map<String, String> params;
  private final Long id;

  /**
   * Constructor for the PartialPetUpdate task.
   *
   * @param params A map of parameters to update the pet.
   * @param id The ID of the pet to be updated.
   */
  public PartialPetUpdate(Map<String, String> params, Long id) {
    this.params = params;
    this.id = id;
  }

  /**
   * Creates a new instance of the PartialPetUpdate task.
   *
   * @param params A map of parameters to update the pet.
   * @param id The ID of the pet to be updated.
   * @return A Performable task to partially update the pet.
   */
  public static Performable withPayload(Map<String, String> params, Long id) {
    return instrumented(PartialPetUpdate.class, params, id);
  }

  /**
   * Performs the action of partially updating a pet.
   *
   * @param actor The actor performing the action.
   * @param <T> The type of the actor.
   */
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to("/pet/{id}")
            .with(
                request ->
                    request
                        .pathParam("id", this.id)
                        .contentType("application/x-www-form-urlencoded")
                        .header("accept", "application/json")
                        .formParams(this.params)));
  }
}
