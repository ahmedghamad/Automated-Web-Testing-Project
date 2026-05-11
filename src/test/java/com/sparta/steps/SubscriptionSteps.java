package com.sparta.steps;
import com.sparta.pages.SubscriptionPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class SubscriptionSteps extends ScenarioSteps {

    SubscriptionPage subscriptionPage;

    @Step("Open Automation Exercise homepage")
    public void open_homepage() {
        subscriptionPage.openHomePage();
    }

    @Step("Scroll to footer")
    public void scroll_to_footer() {
        subscriptionPage.scrollToFooter();
    }

    @Step("Enter email: {0}") //insert First method parameter -> show email
    public void enter_email(String email) {
        subscriptionPage.enterEmail(email);
    }

    @Step("Click subscribe button")
    public void click_subscribe_button() {
        subscriptionPage.clickSubscribe();
    }

    @Step("Verify success message")
    public void verify_success_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, subscriptionPage.getSuccessMessage());
    }
// sad path: empty email
    @Step("Leave email field empty")
    public void empty_email_validation(){
        Assert.assertTrue(subscriptionPage.isValidationEmailDisplayed());
    }
    @Step("Verify user is still on page, form could not be submitted")
    public void verify_subscription_not_submitted(){
        Assert.assertTrue(subscriptionPage.isStillOnPage());
    }
    @Step("Verify error message is displayed")
    public void verify_error_message_displayed(){
        Assert.assertTrue(subscriptionPage.isValidationEmailDisplayed());
    }

}