package co.com.choucair.utest.stepdefinitions;

import co.com.choucair.utest.models.UtestData;
import co.com.choucair.utest.questions.Answer;
import co.com.choucair.utest.tasks.OpenUp;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnlineCast;
import co.com.choucair.utest.tasks.*;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class UtestUserStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("^that Dante wants create user on utest website and enters the page$")
    public void thatDanteWantsCreateUserOnUtestWebsiteAndEntersThePage() {
        theActorCalled("Dante").wasAbleTo(OpenUp.thePage());
    }


    @When("^he filled out the registration from on the utest website$")
    public void heFilledOutTheRegistrationFromOnTheUtestWebsite(List <UtestData> utestData) throws Exception {
        theActorInTheSpotlight().attemptsTo(RegisterOnUtest.onThePage(utestData.get(0)));
    }

    @Then("^he verify that the user is create successfully and verify (.*)$")
    public void heVerifyThatTheUserIsCreateSuccessfullyAndVerifyTheLastStep(String question) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(question)));

    }


}
