package com.sparta.steps;

import com.sparta.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class CheckoutSteps {

    CheckoutPage checkoutPage;
    ProductsPage productsPage;
    HomePage homePage;
    RegistrationPage registrationPage;

    CartPage cartPage;


    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
       MatcherAssert.assertThat(homePage.isLoggedInAsTextDisplayed(), Matchers.is(true));;
    }

    @And("the user has added a product to the cart")
    public void theUserHasAddedAProductToTheCart() {


    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        homePage.open();
        homePage.acceptConsentIfVisible();
        homePage.dismissPopups();
        MatcherAssert.assertThat(homePage.getDriver().getCurrentUrl(), Matchers.is("https://automationexercise.com/checkout"));

    }

    @And("the user clicks the Place Order button")
    public void theUserClicksThePlaceOrderButton() {
        checkoutPage.clickPlaceOrderButton();
    }

    @And("the user enters valid payment details")
    public void theUserEntersValidPaymentDetails() {
        checkoutPage.enterCardName("Test User");

        checkoutPage.enterCardNumber("4111111111111111");

        checkoutPage.enterCVC("123");

        checkoutPage.enterExpiryMonth("12");

        checkoutPage.enterExpiryYear("2030");

        checkoutPage.clickPayAndConfirmButton();
    }

    @Then("the order page should display a confirmation message")
    public void theOrderShouldBePlacedSuccessfully() {
        MatcherAssert.assertThat(
                checkoutPage.isOrderSuccessMessageDisplayed(),
                Matchers.is(true));
    }

    @Then("the delivery address should be displayed correctly")
    public void theDeliveryAddressShouldBeDisplayedCorrectly() {

        MatcherAssert.assertThat(
                checkoutPage.isDeliveryAddressDisplayed(),
                Matchers.is(true));
    }

    @And("the billing address should be displayed correctly")
    public void theBillingAddressShouldBeDisplayedCorrectly() {
        MatcherAssert.assertThat(
                checkoutPage.isBillingAddressDisplayed(),
                Matchers.is(true));
    }

    @Given("the user has successfully placed an order")
    public void theUserHasSuccessfullyPlacedAnOrder() {MatcherAssert.assertThat(
            checkoutPage.isOrderSuccessMessageDisplayed(),
            Matchers.is(true));
    }

    @When("the user clicks the Download Invoice button")
    public void theUserClicksTheDownloadInvoiceButton() {
        checkoutPage.clickDownloadInvoiceButton();
    }

    @Then("the invoice should be downloaded successfully")
    public void theInvoiceShouldBeDownloadedSuccessfully() {

        MatcherAssert.assertThat(
                checkoutPage.isInvoiceDownloaded(),
                Matchers.is(true));
    }

    @Given("the user has added multiple products to the cart")
    public void theUserHasAddedMultipleProductsToTheCart() {

    }

    @Then("the order review section should display all products")
    public void theOrderReviewSectionShouldDisplayAllProducts() {
    }

    @And("the total amount should be displayed correctly")
    public void theTotalAmountShouldBeDisplayedCorrectly() {
    }

    @Given("the user has an empty cart")
    public void theUserHasAnEmptyCart() {
        cartPage.open();
    }

    @When("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        checkoutPage.open();

    }

    @Then("the checkout page should not allow order placement")
    public void theCheckoutPageShouldNotAllowOrderPlacement() {
    }

    @Given("the user is on the payment page")
    public void theUserIsOnThePaymentPage() {
    }

    @When("the user enters invalid card information")
    public void theUserEntersInvalidCardInformation() {
    }

    @And("the user clicks Pay and Confirm Order")
    public void theUserClicksPayAndConfirmOrder() {
    }

    @Then("the payment should fail")
    public void thePaymentShouldFail() {
    }

    @Given("the user is not logged in")
    public void theUserIsNotLoggedIn() {
    }

    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
    }

    @When("the user leaves all payment fields empty")
    public void theUserLeavesAllPaymentFieldsEmpty() {
    }

    @Then("validation messages should be displayed")
    public void validationMessagesShouldBeDisplayed() {
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
    }

    @When("the user refreshes the browser")
    public void theUserRefreshesTheBrowser() {
    }

    @Then("the cart products should still be displayed")
    public void theCartProductsShouldStillBeDisplayed() {
    }


}
