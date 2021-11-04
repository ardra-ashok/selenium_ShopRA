package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        System.out.println("one");
    }
    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        System.out.println("two");
    }
    @When("hits submit")
    public void hits_submit() {
        System.out.println("three");
    }
    @Then("the user should be logged successfully")
    public void logInSuccess() {
        System.out.println("four");
    }
    @Given("the user is in login page")
    public void userOnLogin(){
        System.out.println("five");
    }
    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        System.out.println("six");
    }
    @When("hits submit button")
    public void hits_submitBtn() {
        System.out.println("seven");
    }
    @Then("the user not logged in successfully")
    public void logNotSuccessful() {
        System.out.println("eight");
    }

}
