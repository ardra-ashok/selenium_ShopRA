package StepDefinition;

import Exceptions.ParentException;
import Service.Services;
import StepDefinitions.Credentials;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class Steps {

    private Services service;
    public Steps(){
        service = new Services();
    }
    @Given("the user is on the Home Page")
    public void userOnHome_page() throws ParentException {
        service.navigateToHome_page();
    }
    @Then("follow the Sign in Link")
    public void goSignInPage() throws ParentException {
        service.clickOnSignLink();
    }

    @When("User enters Credentials to LogIn")
    public void entersValidCredentialsToLogin(List<Credentials> usercredentials) throws Throwable {
//Write the code to handle Data Table
        for (Credentials credentials : usercredentials) {
            service.enterLoginCredentials(credentials.getEmail(),credentials.getPassword());
        }
    }
    @Then("Message displayed Login Successfully")
    public void message_displayed_login_successfully() {

    }

    @Then("the user should logged out successfully2")
    public void logOut2() throws ParentException{
        service.clickOnLogout();
    }

}
