package com.co.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

/** A Serenity Screenplay interaction to perform a POST request. */
public class Post extends RestInteraction {

  private final String resource;

  /**
   * Constructor.
   *
   * @param resource The resource to perform the POST request on.
   */
  public Post(String resource) {
    this.resource = resource;
  }

  /**
   * Performs the POST request.
   *
   * @param actor The actor performing the action.
   * @param <T> The type of the actor.
   */
  @Step("{0} executes a POST on the resource #resource")
  @Override
  public <T extends Actor> void performAs(T actor) {
    rest().log().all().post(as(actor).resolve(this.resource)).then().log().all();
  }

  /**
   * Factory method to create a new instance of this interaction.
   *
   * @param resource The resource to perform the POST request on.
   * @return A new instance of this interaction.
   */
  public static Post to(String resource) {
    return instrumented(Post.class, resource);
  }
}
