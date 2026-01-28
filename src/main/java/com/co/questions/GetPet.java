package com.co.questions;

import com.co.models.pets.Pet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** Question to retrieve the Pet from the last response. */
public class GetPet implements Question<Pet> {

  /**
   * Retrieves the Pet from the last response.
   *
   * @param actor the actor performing the action
   * @return the Pet object from the response
   */
  @Override
  public Pet answeredBy(Actor actor) {
    return SerenityRest.lastResponse().as(Pet.class);
  }
}
