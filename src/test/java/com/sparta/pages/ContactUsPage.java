package com.sparta.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoAlertPresentException;
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

    @FindBy(xpath = "//*[contains(normalize-space(),'Success! Your details have been submitted successfully.')]")
    WebElementFacade successMessage;

    //open website, handle cookie immediately
    public void openHomePage() {
        openUrl("https://automationexercise.com");
        acceptCookiesIfVisible();
    }

    public void acceptCookiesIfVisible() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                evaluateJavascript("arguments[0].click();", consentButton);
            }
        } catch (Exception ignored) {
        }
    }

    public void clickContactUs() {
        acceptCookiesIfVisible();
        contactUsLink.waitUntilClickable().click();
    }

    public boolean isContactUsPageDisplayed() {
        return getInTouchHeading.waitUntilVisible().isVisible();
    }

    public void enterName(String name) {
        nameInput.waitUntilVisible().clear();
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.waitUntilVisible().clear();
        emailInput.sendKeys(email);
    }

    public void enterSubject(String subject) {
        subjectInput.waitUntilVisible().clear();
        subjectInput.sendKeys(subject);
    }

    public void enterMessage(String message) {
        messageInput.waitUntilVisible().clear();
        messageInput.sendKeys(message);
    }

    public void uploadFile(String fileName) {
        Path filePath = Paths.get(fileName).toAbsolutePath();
        if (!Files.exists(filePath)) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }

        uploadFileInput.sendKeys(filePath.toString());
    }

    public void clickSubmit() {
        evaluateJavascript("""
        document.querySelectorAll("iframe[id^='aswift'], iframe[title='Advertisement']")
            .forEach(iframe => iframe.remove());
    """);

        submitButton.waitUntilVisible();
        submitButton.submit();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.waitUntilVisible().isVisible();
    }

    public String getSuccessMessageText() {
        return successMessage.waitUntilVisible().getText();
    }

    // Sad path:

    public void clickSubmitWithoutAcceptingAlert() {
        evaluateJavascript("""
        document.querySelectorAll("iframe[id^='aswift'], iframe[title='Advertisement']")
            .forEach(iframe => iframe.remove());
    """);

        submitButton.waitUntilVisible();
        submitButton.submit();
    }

    public boolean isStillOnContactUsPage() {
        return getInTouchHeading.isCurrentlyVisible();
    }

    public boolean isFormNotSubmitted() {
        return !getDriver().getPageSource()
                .contains("Success! Your details have been submitted successfully.");
    }

    public boolean isEmailValidationErrorDisplayed() {
        return Boolean.TRUE.equals(evaluateJavascript("""
        const email = document.querySelector(".contact-form input[data-qa='email']");
        return email && !email.validity.valid;
    """));
    }


}