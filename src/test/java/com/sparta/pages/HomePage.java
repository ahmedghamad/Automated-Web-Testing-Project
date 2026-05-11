package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/")
public class HomePage extends PageObject {


    //Locators

    @FindBy(css = "button.fc-cta-consent")
    private WebElementFacade consentButton;

    @FindBy(css = "a[href='/login']")
    private WebElementFacade signupLoginButton;

    //After login validation locator

    @FindBy(xpath = "//b[normalize-space()='Test_User']")
    private WebElementFacade loggedInAsText;


    //Action methods

    public void acceptConsentIfVisible() {
        try {
            if (consentButton.isVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {
            System.out.println("Consent popup not displayed");
        }
    }

    public void clickSignupLoginButton() {
        signupLoginButton.click();
    }

    public boolean isLoggedInAsTextDisplayed() {
        return loggedInAsText.isDisplayed();
    }


}
