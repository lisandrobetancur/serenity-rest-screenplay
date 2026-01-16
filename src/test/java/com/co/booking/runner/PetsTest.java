package com.co.booking.runner;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import com.co.base.BaseTest;
import com.co.models.pets.Pet;
import com.co.questions.QuestionGetPets;
import com.co.questions.QuestionResponseCode;
import com.co.tasks.TaskFindPets;
import java.util.List;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
class PetsTest extends BaseTest {

  @Test
  void findPetsByStatus() {
    Actor intern = Actor.named("Juanito the intern").whoCan(CallAnApi.at(restApiUrl));

    intern.attemptsTo(TaskFindPets.byStatus("sold"));

    intern.should(seeThat("the status code", QuestionResponseCode.was(), equalTo(SC_OK)));

    List<Pet> pets = new QuestionGetPets().answeredBy(intern);

    Pet pet =
        pets.stream()
            .filter(p -> p.getId() == 690)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Pet ID not found"));

    intern.should(seeThat("intern", actor -> pet, notNullValue()));

    intern.should(
        seeThat("the category id", actor -> pet.getCategory().getId(), equalTo(6)),
        seeThat("the category name", actor -> pet.getCategory().getName(), equalTo("dogs")),
        seeThat("the pet name", actor -> pet.getName(), equalTo("Sharikk")),
        seeThat("the photoUrls", actor -> pet.getPhotoUrls(), equalTo("string")),
        seeThat("the status", actor -> pet.getStatus(), equalTo("sold")));
  }
}
