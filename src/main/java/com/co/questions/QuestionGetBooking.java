package com.co.questions;

import com.co.models.bookings.Booking;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** A Serenity BDD Question to retrieve the last created booking from the API response. */
public class QuestionGetBooking implements Question<Booking> {
  /**
   * Extracts the Booking object from the last RESTAssured response.
   *
   * @param actor The actor performing the action.
   * @return The Booking object.
   */
  @Override
  public Booking answeredBy(Actor actor) {
    return SerenityRest.lastResponse().as(Booking.class);
  }
}
