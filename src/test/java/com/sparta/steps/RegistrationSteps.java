package com.sparta.steps;

import com.sparta.pages.AccountCreatedPage;
import com.sparta.pages.HomePage;
import com.sparta.pages.LoginPage;
import com.sparta.pages.RegistrationPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class RegistrationSteps {

    @Managed
    HomePage homePage;

    @Managed
    LoginPage loginPage;

    @Managed
    RegistrationPage registrationPage;

    @Managed
    AccountCreatedPage accountCreatedPage;

    @Given("the user is on the Home page")
    public void theUserIsOnTheHomePage() {

        homePage.open();
        homePage.acceptConsentIfVisible();
    }

    @When("the user clicks the Signup\\/Login button")
    public void theUserClicksTheSignupLoginButton() {
        homePage.clickSignupLoginButton();
    }


    @And("the user enters a name {string}")
    public void theUserEntersAName(String signupName) {
        loginPage.enterName(signupName);

    }

    @And("the user enters a unique valid email address")
    public void theUserEntersAUniqueValidEmailAddress() {
        String signupEmail = "test" + System.currentTimeMillis() + "@gmail.com";
        loginPage.enterEmail(signupEmail);
    }

    @And("the user clicks the Signup button")
    public void theUserClicksTheSignupButton() {
        loginPage.clickSignupButton();
    }

    @And("the user completes the registration form with valid details")
    public void theUserCompletesTheRegistrationFormWithValidDetails() {
        registrationPage.selectTitle();
        registrationPage.enterPassword("Test@123");
        registrationPage.enterFirstName("Test");
        registrationPage.enterLastName("User");
        registrationPage.enterAddress("123 Test Street");
        registrationPage.selectCountry("Canada");
        registrationPage.enterState("Ontario");
        registrationPage.enterCity("Toronto");
        registrationPage.enterZipcode("M5V 2T6");
        registrationPage.enterMobileNumber("6471234567");


    }

    @And("the user clicks the Create Account button")
    public void theUserClicksTheCreateAccountButton() {
        registrationPage.clickCreateAccount();

    }

    @Then("the account should be created successfully")
    public void theAccountShouldBeCreatedSuccessfully() {
        MatcherAssert.assertThat(accountCreatedPage.isAccountCreated(), Matchers.is(true));
    }

    @And("the {string} message should be displayed")
    public void theMessageShouldBeDisplayed(String expectedMessage) {
        MatcherAssert.assertThat(accountCreatedPage.getAccountCreatedText(), Matchers.equalTo(expectedMessage));
    }


    @And("the user enters an already registered email address {string}")
    public void theUserEntersAnAlreadyRegisteredEmailAddress(String signupEmail) {
        loginPage.enterEmail(signupEmail);
    }

    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String expetedMessage) {
        MatcherAssert.assertThat(loginPage.getExistingEmailErrorMessage(), Matchers.equalTo(expetedMessage));
    }

    @And("the account should not be created")
    public void theAccountShouldNotBeCreated() {
        MatcherAssert.assertThat(registrationPage.getDriver().getCurrentUrl(), Matchers.equalTo("https://automationexercise.com/signup"));
    }


    @Then("user should see success message {string}")
    public void userShouldSeeSuccessMessage(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
