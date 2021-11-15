package StepDefinitions;

import Exceptions.ParentException;


import Service.Services;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




import java.util.List;
import java.util.Map;
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
    public void entersValidCredentials(DataTable userCredentials) throws ParentException {
            List<Map<String, String>> data = userCredentials.asMaps(String.class, String.class);
            service.enterLoginCredentials(data.get(0).get("email"), data.get(0).get("password"));
//            // list of maps
//        for(Map<String,String> data: userCredentials.asMaps(String.class,String.class)){
//            service.enterLoginCredentials(data.get("email"),data.get("password"));
//        }
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
        System.out.println("i am running cucumber");
    }

    @Then("^user then closes the browser$")
    public void tearDown() throws InterruptedException {
        service.tearDown();
    }




}