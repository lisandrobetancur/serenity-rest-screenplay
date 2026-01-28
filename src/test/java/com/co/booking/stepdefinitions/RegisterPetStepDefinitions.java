package com.co.booking.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import com.co.factories.PetFactory;
import com.co.models.pets.Pet;
import com.co.questions.GetPet;
import com.co.questions.ResponseCode;
import com.co.tasks.AddPet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class RegisterPetStepDefinitions {

  private Actor intern;

  @Given("{} wants to add a new pet")
  public void aPetWithTheFollowingDetails(String actorName) {
    intern = Actor.named(actorName).whoCan(CallAnApi.at(System.getProperty("restapi.baseurl")));
  }

  @When("he adds the pet to the store")
  public void theUserAddsThePetToTheStore(List<Map<String, Object>> data) {
    Map<String, Object> petData = data.getFirst();

    Pet.PetBuilder petBuilder = PetFactory.getPet(petData);

    intern.attemptsTo(AddPet.withPayload(petBuilder.build()));
  }

  @Then(
      "the pet should be successfully added with id {int} and the response status code should be {int}")
  public void thePetShouldBeSuccessfullyAdded(Integer id, int statusCode) {
    intern.attemptsTo(Ensure.that("the status code", ResponseCode.was()).isEqualTo(statusCode));

    Pet pet = new GetPet().answeredBy(intern);

    intern.should(seeThat("pet object", actor -> pet, notNullValue()));

    intern.should(seeThat("the pet id", actor -> pet.getId(), equalTo(Long.valueOf(id))));
  }
}
