package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class dummy3 {
    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String arg0, String arg1) throws Throwable {
        System.out.println("username : " + arg0 + " pwd : " + arg1);
        System.out.println();
    }

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() throws Throwable {
        System.out.println("I'm on the login page");
    }

    @Then("^I should be able to login successfully$")
    public void iShouldBeAbleToLoginSuccessfully() throws Throwable {
        System.out.println("I should be able to login successfully");
    }
}
