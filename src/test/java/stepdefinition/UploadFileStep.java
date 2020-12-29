package stepdefinition;


import actions.Time;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import question.UploadFileQuestion;
import question.UploadResultQuestion;
import task.UploadFileTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class UploadFileStep {


    @Managed
    WebDriver driver;

    @Before
    public  void  setUp(){ OnStage.setTheStage(new OnlineCast());
    }

    @Given("^El cliente ingresa a la pagina$")
    public void el_cliente_ingresa_a_la_pagina()  {
        theActorCalled("Cliente").attemptsTo(Open.url("http://the-internet.herokuapp.com/upload"));

    }

    @And("^Visualia el home (.+)$")
    public void visualia_el_home(String inicio)  {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(UploadFileQuestion.InicioValid(inicio),is(true)));
    }


    @When("^el cliente carga el archivo$")
    public void el_cliente_carga_el_archivo() {
        theActorCalled("Cliente").attemptsTo(UploadFileTask.UploadFileTask());
    }

    @Then("^visualiza la carga exitosa (.+)$")
    public void visualiza_la_carga_exitosa(String resultado)  {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(UploadResultQuestion.ResultValid(resultado),is(true)));
        Time.getTimeTwo();
    }





}
