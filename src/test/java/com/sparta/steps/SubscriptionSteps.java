package com.sparta.steps;
import com.sparta.pages.SubscriptionPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class SubscriptionSteps extends ScenarioSteps {

    SubscriptionPage subscriptionPage;

    @Step
    public void open_homepage() {
        subscriptionPage.openHomePage();
    }

    @Step
    public void scroll_to_footer() {
        subscriptionPage.scrollToFooter();
    }

    @Step
    public void enter_email(String email) {
        subscriptionPage.enterEmail(email);
    }

    @Step
    public void click_subscribe_button() {
        subscriptionPage.clickSubscribe();
    }

    @Step
    public void verify_success_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, subscriptionPage.getSuccessMessage());
    }
}