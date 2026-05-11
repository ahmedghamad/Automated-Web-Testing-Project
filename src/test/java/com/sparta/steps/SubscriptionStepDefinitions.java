package com.sparta.steps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class SubscriptionStepDefinitions {

    @Steps
    SubscriptionSteps steps;

    @Given("user opens Automation Exercise homepage")
    public void open_homepage() {
        steps.open_homepage();
    }

    @When("user scrolls to footer")
    public void scroll_footer() {
        steps.scroll_to_footer();
    }

    @When("user enters email {string}")
    public void enter_email(String email) {
        steps.enter_email(email);
    }

    @When("user clicks subscribe button")
    public void click_subscribe() {
        steps.click_subscribe_button();
    }

    @Then("user should see subscription success message {string}")
    public void verify_message(String msg) {
        steps.verify_success_message(msg);
    }
}