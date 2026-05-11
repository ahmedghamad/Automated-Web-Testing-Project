package com.sparta.steps;

import com.sparta.pages.HomePage;
import com.sparta.pages.LoginPage;
import com.sparta.pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class LoginSteps {

    HomePage homePage;
    LoginPage loginPage;


    @And("the user enters a valid email address {string}")
    public void theUserEntersAValidEmailAddress(String loginEmail) {
        loginPage.enterLoginEmail(loginEmail);
    }

    @And("the user enters a valid password {string}")
    public void theUserEntersAValidPassword(String loginPassword) {
        loginPage.enterLoginPassword(loginPassword);
    }

    @And("the user clicks the Login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLoginButton();

    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        MatcherAssert.assertThat(homePage.isLoggedInAsTextDisplayed(), Matchers.is(true));

    }


    @And("the user enters an invalid password {string}")
    public void theUserEntersAnInvalidPassword(String loginPassword) {
        loginPage.enterLoginPassword(loginPassword);

    }

    @Then("the user should see a login error message {string}")
    public void theUserShouldSeeALoginErrorMessage(String expectedError) {
        MatcherAssert.assertThat(loginPage.getLoginErrorMessage(),Matchers.equalTo(expectedError));

    }


}
