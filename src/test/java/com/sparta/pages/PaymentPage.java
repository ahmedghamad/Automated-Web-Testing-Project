package com.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageObject {
    @FindBy(name = "name_on_card")
    private WebElementFacade nameOnCard;

    @FindBy(css = "#payment-form > div:nth-child(3) > div > input")
    private WebElementFacade cardNumber;

    @FindBy(css = "#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input")
    private WebElementFacade cvc;

    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(2) > input")
    private WebElementFacade cardExpiryMonth;

    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(3) > input")
    private WebElementFacade cardExpiryYear;

    @FindBy(css = "#submit")
    private WebElementFacade submit;

    @FindBy(className = "text-center")
    private WebElementFacade message;

    public void enterNameOnCard(String name) {
        nameOnCard.type(name);
    }

    public void enterCardNumber(String number) {
        cardNumber.type(number);
    }

    public void enterCVC(String cvcType) {
        cvc.type(cvcType);
    }

    public void enterExpiryMonth(String month) {
        cardExpiryMonth.type(month);
    }

    public void enterExpiryYear(String year) {
        cardExpiryYear.type(year);
    }

    public void clickPayAndConfirm() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();
    }

    public String getConfirmationMessage() {
        return message.getText();
    }
}