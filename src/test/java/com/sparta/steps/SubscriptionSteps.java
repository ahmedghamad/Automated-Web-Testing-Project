package com.sparta.steps;
import com.sparta.pages.SubscriptionPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SubscriptionSteps {

    SubscriptionPage subscriptionPage;

    @Given("user opens Automation Exercise homepage")
    public void userOpenHomepage() {
        subscriptionPage.openHomePage();
    }

    @When("user scrolls to footer")
    public void userScrollFooter() {
        subscriptionPage.scrollToFooter();
    }

    @When("user enters email {string}")
    @When("user enters invalid email {string}")
    @When("the visitor enters invalid email {string}")
    public void userEnterEmail(String email) {
        subscriptionPage.enterEmail(email);
    }

    @When("user clicks subscribe button")
    public void userClickSubscribe() {
        subscriptionPage.clickSubscribe();
    }

    @Then("user should see subscription success message {string}")
    public void userVerifyMessage(String msg) {
        Assert.assertEquals(msg, subscriptionPage.getSuccessMessage());
    }

    @When("the visitor leaves the email field empty")
    public void leaveEmailFieldEmpty(){
        Assert.assertTrue(subscriptionPage.isValidationEmailDisplayed());
    }

    @Then("the form submission is prevented")
    public void formNotSubmitted(){
        Assert.assertTrue(subscriptionPage.isStillOnPage());
    }

    @And("a required field validation message is displayed")
    public void validationMessageDisplays(){
        Assert.assertTrue(subscriptionPage.isValidationEmailDisplayed());
    }

    @Given("a user has already subscribed with email {string}")
    @When("the user subscribes again with email {string}")
    public void alreadySubscribedWithEmail(String email) {
        userOpenHomepage();
        userScrollFooter();
        userEnterEmail(email);
        userClickSubscribe();
    }
}