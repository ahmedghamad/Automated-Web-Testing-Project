package com.sparta.pages;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubscriptionPage extends PageObject {

    public SubscriptionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class,'fc-cta-consent') or @aria-label='Consent']")
    private WebElementFacade consentButton;

    public void acceptCookiesIfPresent() {
        try {
            if (consentButton.waitUntilVisible().isPresent()) {
                consentButton.click();
            }
        } catch (Exception e) {
            // ignore if not present
        }
    }

    @FindBy(id = "susbscribe_email")
    private WebElementFacade emailInput;

    @FindBy(id = "subscribe")
    private WebElementFacade subscribeBtn;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElementFacade successMsg;

    public void openHomePage() {
        openUrl("https://automationexercise.com");
    }

    public void scrollToFooter() {
        evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
        acceptCookiesIfPresent();
    }

    public void enterEmail(String email) {
        emailInput.waitUntilVisible().type(email);
    }

    public void clickSubscribe() {
        subscribeBtn.click();
    }

    public String getSuccessMessage() {
        return successMsg.waitUntilVisible().getText();
    }
}