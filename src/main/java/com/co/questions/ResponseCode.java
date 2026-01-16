package com.co.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** A Serenity BDD Question to retrieve the HTTP status code from the last API response. */
public class ResponseCode implements Question<Integer> {

  /**
   * Static factory method to create an instance of ResponseCodeQuestion.
   *
   * @return A new instance of ResponseCodeQuestion.
   */
  public static Question<Integer> was() {
    return new ResponseCode();
  }

  /**
   * Extracts the HTTP status code from the last RESTAssured response.
   *
   * @param actor The actor performing the action.
   * @return The HTTP status code.
   */
  @Override
  public Integer answeredBy(Actor actor) {
    return SerenityRest.lastResponse().statusCode();
  }
}
