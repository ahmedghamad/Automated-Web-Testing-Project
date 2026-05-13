package com.sparta.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

@DefaultUrl("https://automationexercise.com/")
public class ContactUsPage extends PageObject {

    @FindBy(css = ".fc-button.fc-cta-consent")
    WebElementFacade consentButton;

    @FindBy(linkText = "Contact us")
    WebElementFacade contactUsLink;

    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    WebElementFacade getInTouchHeading;

    @FindBy(css = ".contact-form input[data-qa='name']")
    WebElementFacade nameInput;

    @FindBy(css = ".contact-form input[data-qa='email']")
    WebElementFacade emailInput;

    @FindBy(css = ".contact-form input[data-qa='subject']")
    WebElementFacade subjectInput;

    @FindBy(css = ".contact-form textarea[data-qa='message']")
    WebElementFacade messageInput;

    @FindBy(css = "input[name='upload_file']")
    WebElementFacade uploadFileInput;

    @FindBy(css = ".contact-form input[data-qa='submit-button']")
    WebElementFacade submitButton;

    private final By successMessageLocator = By.xpath(
            "//div[contains(@class,'alert-success')]"
    );

    // Navigation

    public void openHomePage() {
        openUrl("https://automationexercise.com");
        acceptCookiesIfVisible();
    }

    public void acceptCookiesIfVisible() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                evaluateJavascript("arguments[0].click();", consentButton);
            }
        } catch (Exception ignored) {}
    }

    public void clickContactUs() {
        contactUsLink.waitUntilClickable().click();
    }

    public boolean isContactUsPageDisplayed() {
        return getInTouchHeading.waitUntilVisible().isVisible();
    }

    // Form actions

    public void enterName(String name) {
        nameInput.type(name);
    }

    public void enterEmail(String email) {
        emailInput.type(email);
    }

    public void enterSubject(String subject) {
        subjectInput.type(subject);
    }

    public void enterMessage(String message) {
        messageInput.type(message);
    }

    public void uploadFile(String fileName) {
        Path filePath = Paths.get(fileName).toAbsolutePath();
        if (!Files.exists(filePath)) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }
        uploadFileInput.sendKeys(filePath.toString());
    }

    // Submit

    public void clickSubmit() {

        submitButton.click();

        // alert handling (safe)
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception ignored) {}
    }

    public void clickSubmitWithoutAcceptingAlert() {
        submitButton.click();
    }

    public void waitForSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(successMessageLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            return getDriver().findElement(successMessageLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getSuccessMessageText() {
        return getDriver().findElement(successMessageLocator).getText();
    }

    public boolean isStillOnContactUsPage() {
        return getInTouchHeading.isCurrentlyVisible();
    }
}