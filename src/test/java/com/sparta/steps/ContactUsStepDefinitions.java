package com.sparta.steps;

import com.sparta.pages.ContactUsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;

import java.nio.file.Paths;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContactUsStepDefinitions {

    @Managed
    WebDriver driver;
    @Steps
    ContactUsSteps steps;

    @Before
    public void setUpActor() {
        user.can(BrowseTheWeb.with(driver));
    }

//Serenity screenplay Actor represent a user
    Actor user = Actor.named("User");
// Background
    @Given("the user is on the Contact Us page")
    public void theUserIsOnTheContactUsPage() {
        user.attemptsTo(Open.url(ContactUsPage.URL));
    }
//// Happy path
    @When("the user enters a valid name")
    public void theUserEntersAValidName() {
        user.attemptsTo(Enter.theValue("Anne")
                .into(ContactUsPage.NAME));
    }

    @And("the user enters a valid email address")
    public void theUserEntersAValidEmailAddress() {
        user.attemptsTo(Enter.theValue("a@gmail.con")
                .into(ContactUsPage.EMAIL));
    }

    @And("the user enters a subject")
    public void theUserEntersASubject() {
        user.attemptsTo(Enter.theValue("a test subject")
                .into(ContactUsPage.SUBJECT));
    }

    @And("the user enters a message")
    public void theUserEntersAMessage() {
        user.attemptsTo(Enter.theValue("a message")
                .into(ContactUsPage.MESSAGE));
    }

    @And("the user uploads a file")
    public void theUserUploadsAFile() {
       user.attemptsTo(Upload.theFile(Paths.get("src/test/resources/fileToTestContactUsForm.jpg"))
               .to(ContactUsPage.UPLOAD_FILE));
    }

    @And("the user clicks the Submit button")
    public void theUserClicksTheSubmitButton() {
        user.attemptsTo(
                Click.on(ContactUsPage.SUBMIT)
        );
    }

    @And("the user accepts the confirmation alert")
    public void theUserAcceptsTheConfirmationAlert() {
        user.attemptsTo(
                Switch.toAlert().andAccept()
        );
    }

    @Then("the form should be submitted successfully")
    public void theFormShouldBeSubmittedSuccessfully() {
        assertThat(ContactUsPage.SUCCESS_MESSAGE.resolveFor(user).isVisible())
                .isTrue();
    }


    @And("the user should see the message {string}")
    public void theUserShouldSeeTheMessage(String message) {
            assertThat(
                    ContactUsPage.SUCCESS_MESSAGE.resolveFor(user)
                    .getText())
                    .contains(message);
    }

// Sad path:  Submission with Missing Required Fields

    @When("the user enters name {string}")
    public void theUserEntersName(String name) {
        user.attemptsTo(Enter.theValue(name)
                .into(ContactUsPage.NAME));
    }

    @And("the user enters email {string}")
    public void theUserEntersEmail(String email) {
        user.attemptsTo(Enter.theValue(email)
                .into(ContactUsPage.EMAIL));
    }

    @And("the user enters subject {string}")
    public void theUserEntersSubject(String subject) {
        user.attemptsTo(Enter.theValue(subject)
                .into(ContactUsPage.SUBJECT));
    }

    @And("the user enters message {string}")
    public void theUserEntersMessage(String message) {
        user.attemptsTo(Enter.theValue(message)
                .into(ContactUsPage.MESSAGE));
    }

    @Then("the form should not be submitted")
    public void theFormShouldNotBeSubmitted() {
        assertThat(
                ContactUsPage.SUCCESS_MESSAGE.resolveFor(user).isVisible()
        ).isFalse();
    }

    @And("the user should remain on the Contact Us page")
    public void theUserShouldRemainOnTheContactUsPage() {
        assertThat(ContactUsPage.NAME.resolveFor(user).isVisible()).isTrue();
//if name field is still visible, user is still on the contact us page
    }

// Sad Path: invalid email
    @And("the user enters an invalid email address {string}")
    public void theUserEntersAnInvalidEmailAddress(String invalidEmail) {
        user.attemptsTo(
                Enter.theValue(invalidEmail)
                        .into(ContactUsPage.EMAIL)
        );

    }

    @And("an email validation error should be displayed")
    public void anEmailValidationErrorShouldBeDisplayed() {
        String validationMessage =
                ContactUsPage.EMAIL.resolveFor(user).getAttribute("validationMessage");
        assertThat(validationMessage).isNotEmpty();
    }
}
