package StepDefs;

import Exceptions.ParentException;
import Runners.CucumberParams;
import Service.Services;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class Steps {

    private Services service;

    public Steps() {
        service = new Services();

    }

    @Given("^the user is on the Home Page$")
    public void userOnHomePage() throws ParentException {
        service.navigateToHome_page();
    }
    @Then("^follow the Sign in Link$")
    public void goSignInPage() throws ParentException {
        service.clickOnSignLink();
    }
    @When("^the user enters valid Credentials to login$")
    public void entersValidCredentials() throws ParentException {
        String email = CucumberParams.getValue("email");
        String password = CucumberParams.getValue("password");
        service.enterLoginCredentials(email, password);
    }
    @When("^hits submit button$")
    public void hitSubmit() throws ParentException {
        service.submitLogin();
    }
    @Then("^the user found the success text$")
    public void userLoginSuccessful() throws ParentException {
        boolean loggedIn = service.isLoggedIn();
        assertEquals(loggedIn, true);
    }
    @Then("^the user clicks on logout$")
    public void logOut() throws ParentException {
        service.clickOnLogout();
    }

}
