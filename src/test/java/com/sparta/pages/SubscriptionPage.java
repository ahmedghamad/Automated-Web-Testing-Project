package com.sparta.pages;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubscriptionPage extends PageObject {

    public SubscriptionPage(WebDriver driver) {
        super(driver);
    }

    @SuppressWarnings("unused")
    @FindBy(xpath = "//button[contains(@class,'fc-cta-consent') or @aria-label='Consent']")
    private WebElementFacade consentButton;

    // The website intentionally uses the misspelled id "susbscribe_email".
    @SuppressWarnings("unused")
    @FindBy(id = "susbscribe_email")
    private WebElementFacade emailInput;

    @SuppressWarnings("unused")
    @FindBy(id = "subscribe")
    private WebElementFacade subscribeBtn;

    @SuppressWarnings("unused")
    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElementFacade successMsg;

    //Handle cookie immediately
    public void openHomePage() {
        openUrl("https://automationexercise.com");
        acceptCookiesIfPresent();
    }

    public void acceptCookiesIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                evaluateJavascript("arguments[0].click();", consentButton);
            }
        } catch (Exception ignored) {
            // Cookie banner is not always displayed.
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