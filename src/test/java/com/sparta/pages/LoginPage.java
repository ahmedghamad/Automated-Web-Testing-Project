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
    private WebElementFacade signupButton;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElementFacade existingEmailErrorMessage;

    //Login page Locators
    @FindBy(css = "input[data-qa='login-email']")
    private WebElementFacade loginEmail;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElementFacade loginPassword;

    @FindBy(css = "button[data-qa='login-button']")
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
        evaluateJavascript("arguments[0].scrollIntoView(true);", signupButton);

        evaluateJavascript("arguments[0].click();", signupButton);
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
        evaluateJavascript("arguments[0].scrollIntoView(true);", loginButton);
        evaluateJavascript("arguments[0].click();", loginButton);

    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

}
