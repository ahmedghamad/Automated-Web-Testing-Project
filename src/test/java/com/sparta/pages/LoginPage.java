package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends PageObject {

    //Signup Page Locators
    @FindBy(css = "input[data-qa='signup-name']")
    private WebElementFacade signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElementFacade signupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElementFacade signUpButton;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElementFacade existingEmailErrorMessage;

    //Login page Locators
    @FindBy(name = "email")
    private WebElementFacade loginEmail;

    @FindBy(name = "password")
    private WebElementFacade loginPassword;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElementFacade loginErrorMessage;


    //Signup page methods
    public void enterName(String signupName) {
        this.signupName.type(signupName);
    }

    public void enterEmail(String signupEmail) {
        this.signupEmail.type(signupEmail);
    }

    public void clickSignupButton() {
        this.signUpButton.click();
    }

    public String getExistingEmailErrorMessage() {
        return existingEmailErrorMessage.getText();
    }

    //Login Action methods
    public void enterLoginEmail(String loginEmail) {
        this.loginEmail.type(loginEmail);
    }

    public void enterLoginPassword(String loginPassword) {
        this.loginPassword.type(loginPassword);
    }

    public void clickLoginButton() {
        this.loginButton.click();

    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

}
