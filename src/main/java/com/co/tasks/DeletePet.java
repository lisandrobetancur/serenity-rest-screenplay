package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.interactions.Get;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class DeletePet implements Task {

  private final Long id;

  public DeletePet(Long id) {
    this.id = id;
  }

  public static Performable withId(Long id) {
    return instrumented(DeletePet.class, id);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.to("/pet/{id}")
            .with(request -> request.pathParam("id", this.id).contentType(ContentType.JSON)));
  }
}
