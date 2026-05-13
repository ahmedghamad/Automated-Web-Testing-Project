package com.sparta.steps;

import com.sparta.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.is;

public class CheckoutSteps {

    CheckoutPage checkoutPage;
    ProductsPage productsPage;
    ProductPage productPage;

    PaymentPage paymentPage;
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    CartPage cartPage;


    @Given("I am logged in using email {string} and password {string}")
    public void iAmLoggedInUsingEmailAndPassword(String loginEmail, String loginPassword) {
        homePage.open();
        homePage.dismissPopups();
        homePage.clickLoginLink();
        loginPage.enterLoginEmail(loginEmail);
        loginPage.enterLoginPassword(loginPassword);
        loginPage.clickLoginButton();


    }

    @And("the user has added a product to the cart")
    public void theUserHasAddedAProductToTheCart() {
        homePage.viewProduct();
        productPage.clickAddToCartButton();
        productPage.clickContinueShopping();

    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        productPage.clickOnCart();
        cartPage.proceedToCheckout();
    }

    @And("the user clicks the Place Order button")
    public void theUserClicksThePlaceOrderButton() {
        checkoutPage.clickPlaceOrderButton();
    }

    @And("the user enters valid payment details")
    public void theUserEntersValidPaymentDetails() {
        paymentPage.enterNameOnCard("Test User");

        paymentPage.enterCardNumber("4111111111111111");

        paymentPage.enterCVC("123");

        paymentPage.enterExpiryMonth("12");

        paymentPage.enterExpiryYear("2030");

        paymentPage.clickPayAndConfirm();
    }

    @Then("the order page should display a confirmation message")
    public void theOrderShouldBePlacedSuccessfully() {
        MatcherAssert.assertThat(
                paymentPage.getConfirmationMessage(), is("ORDER PLACED!"));
    }

    @Then("the delivery address should be displayed correctly")
    public void theDeliveryAddressShouldBeDisplayedCorrectly() {

        MatcherAssert.assertThat(
                checkoutPage.isDeliveryAddressDisplayed(),
                is(true));
    }

    @And("the billing address should be displayed correctly")
    public void theBillingAddressShouldBeDisplayedCorrectly() {
        MatcherAssert.assertThat(
                checkoutPage.isBillingAddressDisplayed(),
                is(true));
    }

    @Given("the user has successfully placed an order")
    public void theUserHasSuccessfullyPlacedAnOrder() {MatcherAssert.assertThat(
            checkoutPage.isOrderSuccessMessageDisplayed(),
            is(true));
    }

    @When("the user clicks the Download Invoice button")
    public void theUserClicksTheDownloadInvoiceButton() {
        checkoutPage.clickDownloadInvoiceButton();
    }

    @Then("the invoice should be downloaded successfully")
    public void theInvoiceShouldBeDownloadedSuccessfully() {

        MatcherAssert.assertThat(
                checkoutPage.isInvoiceDownloaded(),
                is(true));
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


    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
    }
}
