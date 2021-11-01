package StepDefinitions;

import Exceptions.ParentException;

import Service.Services;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;



// in a normal scenario , add tables for the variables
public class Steps {
    private  Services service;

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

    @When("^the user enters valid credentials - \"([^\"]*)\" and \"([^\"]*)\"$")
    public void entersValidCredentials(String email,String password) throws ParentException {
        service.enterLoginCredentials(email, password);

    }
    @When("hits submit for success login")
    public void hitSubmit() throws ParentException {
        service.submitLogin();
    }
    @Then("the user should logged out successfully")
    public void logOut() throws ParentException{
        service.clickOnLogout();
    }

    @Then("the user should be logged in successfully")
    public void logInSuccessful() throws ParentException {
        boolean loggedIn = service.isLoggedIn();
        assertEquals(loggedIn,true);
    }


    @When("^the user enters invalid credentials - \"([^\"]*)\" and \"([^\"]*)\"$")
    public void entersInValidCredentials(String email,String password) throws ParentException {
        service.enterLoginCredentials(email, password);

    }
    @When("hits submit for unsuccessful login")
    public void hitSubmitUnsuccessfulLogin() throws ParentException {
        service.submitLogin();
    }


   @Then("the user should not be logged in successfully")
    public void LoggingInUnsuccessful() throws ParentException {
        boolean loggedIn = service.isLoggedIn();

        assertEquals(loggedIn,false);
    }

    @When("the user enters valid Credentials to login")
    public void entersValidCredentialsLogin(DataTable usercredentials) throws ParentException {
        List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
        service.enterLoginCredentials(data.get(0).get("email"),data.get(0).get("password"));
    }
    @When("hits submit for success login1")
    public void hitSubmit1() throws ParentException {
        service.submitLogin();
    }
    @Then("the user found the success text")
    public void logInSuccessfulTextFound() throws ParentException {
        boolean loggedIn = service.isLoggedIn();
        assertEquals(loggedIn,true);
    }
    @Then("the user should logged out successfully1")
    public void logOut1() throws ParentException{
        service.clickOnLogout();
    }

    @When("^User enters Credentials to LogIn$")
    public void userEntersCredentialsToLoginPage(List<Credentials> usercredentials) throws ParentException {

        for (Credentials credentials : usercredentials) {

            service.enterLoginCredentials(credentials.getEmail(), credentials.getPassword());
        }
    }

    @When("hits submit for success login2")
    public void hits_submit_for_success_login2() throws ParentException {
        service.submitLogin();
    }
        @Then("Message displayed Login Successfully")
        public void message_displayed_login_successfully () throws ParentException {
            boolean loggedIn = service.isLoggedIn();
            assertEquals(loggedIn, true);
        }

    @Then("the user should logged out successfully2")
    public void logOut2() throws ParentException {
        service.clickOnLogout();
    }







}
