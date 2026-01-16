package com.co.questions;

import com.co.models.pets.Pet;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** A Serenity BDD Question to retrieve a list of Pet objects from the last API response. */
public class GetPets implements Question<List<Pet>> {
  /**
   * Extracts a list of Pet objects from the last RESTAssured response.
   *
   * @param actor The actor performing the action.
   * @return A list of Pet objects.
   */
  @Override
  public List<Pet> answeredBy(Actor actor) {
    return SerenityRest.lastResponse().as(new TypeRef<>() {});
  }
}
