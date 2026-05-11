package com.sparta.pages;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubscriptionPage extends PageObject {
//waitUntilVisible -> prevent timing problems like pop up

    public SubscriptionPage(WebDriver driver) {
        super(driver);
    }
//close cookies pop up
    @FindBy(xpath = "//button[contains(@class,'fc-cta-consent') or @aria-label='Consent']")
    private WebElementFacade consentButton;

    @FindBy(id = "susbscribe_email")//wrong spelling used by the website
    private WebElementFacade emailInput;

    @FindBy(id = "subscribe")
    private WebElementFacade subscribeBtn;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElementFacade successMsg;

//open website, handle cookie immediately
    public void openHomePage() {
        openUrl("https://automationexercise.com");
        acceptCookiesIfPresent();
    }

//handle cookie pop up problem
//Selenium click might fail because of overlays => use Js to click
    public void acceptCookiesIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                evaluateJavascript("arguments[0].click();", consentButton);
            }
        } catch (Exception e) {
            // ignore if not present
        }
    }

    public void scrollToFooter() {
        acceptCookiesIfPresent();
        evaluateJavascript("arguments[0].scrollIntoView(true);", emailInput);
    }

    public void enterEmail(String email) {
        emailInput.waitUntilClickable();
        emailInput.clear();
        emailInput.type(email);
    }
//sad path empty email
    public void leaveEmailFieldEmpty(){
        emailInput.waitUntilClickable();
        emailInput.clear();
    }

    public void clickSubscribe() {
        acceptCookiesIfPresent();
        subscribeBtn.waitUntilClickable().click();
    }

    public String getSuccessMessage() {
        return successMsg.waitUntilVisible().getText();
    }

//return true if validation exist
    public boolean isValidationEmailDisplayed(){
        String message = emailInput.getAttribute("validationMessage");
        return message != null && !message.trim().isEmpty();
    }
//verify user still stay on page
    public boolean isStillOnPage(){
        return getDriver().getCurrentUrl().contains("automationexercise.com");
    }

}