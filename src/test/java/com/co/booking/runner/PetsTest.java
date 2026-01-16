package com.co.booking.runner;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import com.co.models.pets.Category;
import com.co.models.pets.Pet;
import com.co.models.pets.Tag;
import com.co.questions.QuestionGetPets;
import com.co.questions.QuestionResponseCode;
import com.co.tasks.TaskAddPet;
import com.co.tasks.TaskFindPets;
import com.co.tasks.TaskPartialPetUpdate;
import com.co.tasks.TaskPetUpdate;
import com.co.utils.RandomNumber;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
class PetsTest {

  private static Actor intern;
  private final String status = "pending";

  @BeforeAll
  static void setUp() {
    intern =
        Actor.named("Juanito the intern")
            .whoCan(CallAnApi.at(System.getProperty("restapi.baseurl")));
  }

  @Test
  @Order(1)
  void addNewPet() {
    Pet pet =
        Pet.builder()
            .id(RandomNumber.getValue())
            .category(Category.builder().id(6L).name("cat").build())
            .name("Lupe")
            .photoUrls(List.of("https://example.com/image_lupe.jpg"))
            .tags(List.of(Tag.builder().id(6L).name("cat").build()))
            .status(status)
            .build();

    intern.attemptsTo(TaskAddPet.withPayload(pet));

    intern.should(seeThat("the status code", QuestionResponseCode.was(), equalTo(SC_OK)));
  }

  @Test
  @Order(2)
  void findPetsByStatus() {
    intern.attemptsTo(TaskFindPets.byStatus(status));

    intern.should(seeThat("the status code", QuestionResponseCode.was(), equalTo(SC_OK)));

    List<Pet> pets = new QuestionGetPets().answeredBy(intern);

    Pet pet =
        pets.stream()
            .filter(p -> p.getId() == 7937L)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Pet ID not found"));

    intern.should(seeThat("intern", actor -> pet, notNullValue()));

    intern.should(
        seeThat("the category id", actor -> pet.getCategory().getId(), equalTo(6)),
        seeThat("the category name", actor -> pet.getCategory().getName(), equalTo("cat")),
        seeThat("the pet name", actor -> pet.getName(), equalTo("Lupe")),
        seeThat("the photoUrls", actor -> pet.getPhotoUrls().getFirst(), equalTo("string")),
        seeThat("the status", actor -> pet.getStatus(), equalTo(status)));
  }

  @Test
  @Order(3)
  void updatePet() {
    Pet newPet =
        Pet.builder()
            .id(7937L)
            .category(Category.builder().id(7L).name("dog").build())
            .name("Coco")
            .photoUrls(List.of("https://example.com/image_coco.jpg"))
            .tags(List.of(Tag.builder().id(7L).name("dog").build()))
            .status(status)
            .build();

    intern.attemptsTo(TaskPetUpdate.withPayload(newPet));

    intern.should(seeThat("the status code", QuestionResponseCode.was(), equalTo(SC_OK)));
  }

  @Test
  @Order(4)
  void updatePetById() {
    Map<String, String> params = new HashMap<>();
    params.put("name", "Checho");
    params.put("status", "sold");

    intern.attemptsTo(TaskPartialPetUpdate.withPayload(params, 7937L));

    intern.should(seeThat("the status code", QuestionResponseCode.was(), equalTo(SC_OK)));
  }
}
