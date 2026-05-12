package com.sparta.steps;
import com.sparta.pages.SubscriptionPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SubscriptionSteps {

    SubscriptionPage subscriptionPage;

    @Given("user opens Automation Exercise homepage")
    public void open_homepage() {
        subscriptionPage.openHomePage();
    }

    @When("user scrolls to footer")
    public void scroll_footer() {
        subscriptionPage.scrollToFooter();
    }

    @When("user enters email {string}")
    @When("user enters invalid email {string}")
    @When("the visitor enters invalid email {string}")
    public void enter_email(String email) {
        subscriptionPage.enterEmail(email);
    }

    @When("user clicks subscribe button")
    public void click_subscribe() {
        subscriptionPage.clickSubscribe();
    }

    @Then("user should see subscription success message {string}")
    public void verify_message(String msg) {
        Assert.assertEquals(msg, subscriptionPage.getSuccessMessage());
    }

    @When("the visitor leaves the email field empty")
    public void email_field_empty(){
        Assert.assertTrue(subscriptionPage.isValidationEmailDisplayed());
    }

    @Then("the form submission is prevented")
    public void form_not_submitted(){
        Assert.assertTrue(subscriptionPage.isStillOnPage());
    }

    @And("a required field validation message is displayed")
    public void validation_message_displays(){
        Assert.assertTrue(subscriptionPage.isValidationEmailDisplayed());
    }

    @Given("a user has already subscribed with email {string}")
    @When("the user subscribes again with email {string}")
    public void aUserHasAlreadySubscribedWithEmail(String email) {
        open_homepage();
        scroll_footer();
        enter_email(email);
        click_subscribe();
    }
}