package com.sparta.steps;

import com.sparta.pages.ContactUsPage;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import static org.assertj.core.api.Assertions.assertThat;


public class ContactUsSteps {

    @ManagedPages
    Pages pages;

    ContactUsPage contactUsPage;

    @Given("user launches the application")
    public void userLaunchesTheApplication() {
        contactUsPage.openHomePage();
        contactUsPage.acceptCookiesIfVisible();
    }

    @When("user navigates to Contact Us page")
    public void userNavigatesToContactUsPage() {
        contactUsPage.clickContactUs();
        assertThat(contactUsPage.isContactUsPageDisplayed()).isTrue();
    }

    @And("user enters name {string}")
    public void userEntersName(String name) {
        contactUsPage.enterName(name);
    }

    @And("user enters a contact email {string}")
    public void userEntersEmail(String email1) {
        contactUsPage.enterEmail(email1);
    }

    @And("user enters subject {string}")
    public void userEntersSubject(String subject) {
        contactUsPage.enterSubject(subject);
    }

    @And("user enters message {string}")
    public void userEntersMessage(String message) {
        contactUsPage.enterMessage(message);
    }

    @And("user uploads file {string}")
    public void userUploadsFile(String fileName) {
        contactUsPage.uploadFile(fileName);
    }

    @And("user clicks submit button")
    public void userClicksSubmitButton() {
        contactUsPage.clickSubmit();
    }

    @Then("success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        assertThat(contactUsPage.isSuccessMessageDisplayed()).isTrue();
        assertThat(contactUsPage.getSuccessMessageText())
                .contains("Success! Your details have been submitted successfully.");
    }

    // Sad paths:

    @When("user clicks submit button without accepting alert")
    public void userClicksSubmitButtonWithoutAcceptingAlert() {
        contactUsPage.clickSubmitWithoutAcceptingAlert();
    }

    @Then("the form should not be submitted")
    public void theFormShouldNotBeSubmitted() {
        assertThat(contactUsPage.isSuccessMessageDisplayed())
                .as("Success message should NOT be displayed")
                .isFalse();
    }

    @And("the user should remain on the Contact Us page")
    public void theUserShouldRemainOnTheContactUsPage() {
        assertThat(contactUsPage.isStillOnContactUsPage()).isTrue();
    }
}