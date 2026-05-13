package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/account_created")
public class AccountCreatedPage extends PageObject {

    //Locators
    @FindBy(css = "h2[data-qa='account-created']")
    private WebElementFacade accountCreatedMessage;

    //Action methods
    public boolean isAccountCreated() {

        return accountCreatedMessage.isDisplayed();
    }

    public String getAccountCreatedText() {

        return this.accountCreatedMessage.getText();
    }


}
