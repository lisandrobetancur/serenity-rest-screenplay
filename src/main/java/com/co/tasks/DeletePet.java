package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.interactions.Delete;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

/** A Serenity Screenplay task to delete a pet by its ID. */
public class DeletePet implements Task {

  private final Long id;

  /**
   * Constructor for the DeletePet task.
   *
   * @param id The ID of the pet to be deleted.
   */
  public DeletePet(Long id) {
    this.id = id;
  }

  /**
   * Creates a new instance of the DeletePet task.
   *
   * @param id The ID of the pet to be deleted.
   * @return A Performable task to delete the pet.
   */
  public static Performable withId(Long id) {
    return instrumented(DeletePet.class, id);
  }

  /**
   * Performs the action of deleting a pet.
   *
   * @param actor The actor performing the action.
   * @param <T> The type of the actor.
   */
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Delete.to("/pet/{id}")
            .with(request -> request.pathParam("id", this.id).contentType(ContentType.JSON)));
  }
}
