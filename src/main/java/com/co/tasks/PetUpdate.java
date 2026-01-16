package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.interactions.Put;
import com.co.models.pets.Pet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class PetUpdate implements Task {

  private final Pet payload;

  public PetUpdate(Pet payload) {
    this.payload = payload;
  }

  public static Performable withPayload(Pet payload) {
    return instrumented(PetUpdate.class, payload);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Put.to("/pet")
            .with(
                requestSpecification ->
                    requestSpecification.contentType(ContentType.JSON).body(payload)));
  }
}
