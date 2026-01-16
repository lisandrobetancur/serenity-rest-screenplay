package com.co.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

/** A Serenity Screenplay interaction to perform a PUT request. */
public class Put extends RestInteraction {

  private final String resource;

  /**
   * Constructor.
   *
   * @param resource The resource to perform the PUT request on.
   */
  public Put(String resource) {
    this.resource = resource;
  }

  /**
   * Performs the PUT request.
   *
   * @param actor The actor performing the action.
   * @param <T> The type of the actor.
   */
  @Step("{0} executes a PUT on the resource #resource")
  @Override
  public <T extends Actor> void performAs(T actor) {
    rest().log().all().put(as(actor).resolve(this.resource)).then().log().all();
  }

  /**
   * Factory method to create a new instance of this interaction.
   *
   * @param resource The resource to perform the PUT request on.
   * @return A new instance of this interaction.
   */
  public static Put to(String resource) {
    return instrumented(Put.class, resource);
  }
}
