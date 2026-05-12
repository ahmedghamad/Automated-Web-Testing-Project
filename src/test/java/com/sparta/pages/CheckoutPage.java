package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/checkout")
public class CheckoutPage extends PageObject {

    @FindBy(name = "message")
    private WebElementFacade commentBox;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    private WebElementFacade placeOrderButton;

    @FindBy(name = "name_on_card")
    private WebElementFacade nameOnCardField;

    @FindBy(name = "card_number")
    private WebElementFacade cardNumberField;

    @FindBy(name = "cvc")
    private WebElementFacade cvcField;

    @FindBy(name = "expiry_month")
    private WebElementFacade expiryMonthField;

    @FindBy(name = "expiry_year")
    private WebElementFacade expiryYearField;

    @FindBy(id = "submit")
    private WebElementFacade payAndConfirmButton;

    @FindBy(xpath = "//*[contains(text(),'Your order has been placed successfully!')]")
    private WebElementFacade successMessage;

    @FindBy(xpath = "//h2[contains(text(),'Address Details')]")
    private WebElementFacade addressDetailsSection;

    @FindBy(xpath = "//h2[contains(text(),'Review Your Order')]")
    private WebElementFacade orderReviewSection;

    @FindBy (css=".check_out")

    private WebElementFacade invoiceDownloadedMessage;

    @FindBy(xpath = "//u[contains(text(),'Register / Login')]")
    private WebElementFacade loginRedirectText;

    public void enterComment(String comment) {

        commentBox.type(comment);
    }

    public void clickPlaceOrderButton() {

        placeOrderButton.click();
    }

    public void enterCardName(String name) {

        nameOnCardField.type(name);
    }

    public void enterCardNumber(String number) {

        cardNumberField.type(number);
    }

    public void enterCVC(String cvc) {

        cvcField.type(cvc);
    }

    public void enterExpiryMonth(String month) {

        expiryMonthField.type(month);
    }

    public void enterExpiryYear(String year) {

        expiryYearField.type(year);
    }

    public void clickPayAndConfirmButton() {

        payAndConfirmButton.click();
    }

    public boolean isOrderSuccessMessageDisplayed() {

        return successMessage.isDisplayed();
    }

    public boolean isDeliveryAddressDisplayed() {

        return addressDetailsSection.isDisplayed();
    }

    public boolean isBillingAddressDisplayed() {

        return addressDetailsSection.isDisplayed();
    }

    public boolean isOrderReviewDisplayed() {

        return orderReviewSection.isDisplayed();
    }

    public boolean isTotalAmountDisplayed() {

        return orderReviewSection.isDisplayed();
    }

    public void clickDownloadInvoiceButton() {

    }

    public boolean isInvoiceDownloaded() {

        return invoiceDownloadedMessage.isDisplayed();
    }

    public boolean isPaymentErrorDisplayed() {

        return false;
    }

    public boolean areValidationMessagesDisplayed() {

        return false;
    }

    public boolean isRedirectedToLoginPage() {

        return loginRedirectText.isDisplayed();
    }

}