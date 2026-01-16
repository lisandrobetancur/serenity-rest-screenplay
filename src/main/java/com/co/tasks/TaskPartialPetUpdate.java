package com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.interactions.Post;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class TaskPartialPetUpdate implements Task {

  private final Map<String, String> params;
  private final Long id;

  public TaskPartialPetUpdate(Map<String, String> params, Long id) {
    this.params = params;
    this.id = id;
  }

  public static Performable withPayload(Map<String, String> params, Long id) {
    return instrumented(TaskPartialPetUpdate.class, params, id);
  }

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
