package com.sparta.steps;
import io.cucumber.java.PendingException;
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
    @When("user enters invalid email {string}")
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

    @When("the visitor leaves the email field empty")
    public void email_field_empty(){
        steps.empty_email_validation();
    }

    @Then("the form submission is prevented")
    public void form_not_submitted(){
        steps.verify_subscription_not_submitted();
    }

    @And("a required field validation message is displayed")
    public void validation_message_displays(){
        steps.verify_error_message_displayed();
    }

    @When("the visitor enters invalid email {string}")
    public void theVisitorEntersInvalidEmail(String email) {
        steps.enter_email(email);
    }

    @Given("a user has already subscribed with email {string}")
    @When("the user subscribes again with email {string}")
    public void aUserHasAlreadySubscribedWithEmail(String email) {
        steps.open_homepage();
        steps.scroll_to_footer();
        steps.enter_email(email);
        steps.click_subscribe_button();
    }
}