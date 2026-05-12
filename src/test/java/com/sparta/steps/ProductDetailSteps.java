package com.sparta.steps;

import com.sparta.pages.HomePage;
import com.sparta.pages.ProductDetailsPage;
import com.sparta.pages.ProductsPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class ProductDetailSteps {

    @Managed
    HomePage homePage;

    @Managed
    ProductsPage productsPage;

    @Managed
    ProductDetailsPage productDetailsPage;

    @When("I click View Product on the first product")
    public void iClickViewProductOnTheFirstProduct() {
        productsPage.acceptConsentIfVisible();
        productDetailsPage.open();
    }

    @Then("the product details page should open")
    public void theProductDetailsPageShouldOpen() {
        MatcherAssert.assertThat(productDetailsPage.isOnProductDetailsPage(), Matchers.is(true));
    }

    @And("the product image should be displayed")
    public void theProductImageShouldBeDisplayed() {
        MatcherAssert.assertThat(productDetailsPage.isProductImageDisplayed(), Matchers.is(true));
    }

    @And("the product name should be displayed")
    public void theProductNameShouldBeDisplayed() {
        MatcherAssert.assertThat(productDetailsPage.isProductNameDisplayed(), Matchers.is(true));
    }

    @And("the product price should be displayed")
    public void theProductPriceShouldBeDisplayed() {
        MatcherAssert.assertThat(productDetailsPage.isProductPriceDisplayed(), Matchers.is(true));
    }

    @And("the product category should be displayed")
    public void theProductCategoryShouldBeDisplayed() {
        MatcherAssert.assertThat(productDetailsPage.isProductCategoryDisplayed(), Matchers.is(true));
    }

    @And("the product brand should be displayed")
    public void theProductBrandShouldBeDisplayed() {
        MatcherAssert.assertThat(productDetailsPage.isProductBrandDisplayed(), Matchers.is(true));
    }

    @And("the product availability should be displayed")
    public void theProductAvailabilityShouldBeDisplayed() {
        MatcherAssert.assertThat(productDetailsPage.isProductAvailabilityDisplayed(), Matchers.is(true));
    }

    @And("the product condition should be displayed")
    public void theProductConditionShouldBeDisplayed() {
        MatcherAssert.assertThat(productDetailsPage.isProductConditionDisplayed(), Matchers.is(true));
    }

    @Then("the Add to Cart button should be visible and enabled")
    public void theAddToCartButtonShouldBeVisibleAndEnabled() {
        MatcherAssert.assertThat(productDetailsPage.isAddToCartButtonVisible(), Matchers.is(true));
        MatcherAssert.assertThat(productDetailsPage.isAddToCartButtonEnabled(), Matchers.is(true));
    }

    @Then("the quantity field should be visible")
    public void theQuantityFieldShouldBeVisible() {
        MatcherAssert.assertThat(productDetailsPage.isQuantityFieldVisible(), Matchers.is(true));
    }

    @And("the quantity field should have a default value of {int}")
    public void theQuantityFieldShouldHaveADefaultValueOf(int expectedValue) {
        MatcherAssert.assertThat(productDetailsPage.getQuantityValue(), Matchers.is(String.valueOf(expectedValue)));
    }

    @Then("the Write Your Review section should be visible")
    public void theWriteYourReviewSectionShouldBeVisible() {
        MatcherAssert.assertThat(productDetailsPage.isWriteReviewSectionVisible(), Matchers.is(true));
    }

    @When("I navigate to a non-existent product with id {int}")
    public void iNavigateToANonExistentProductWithId(int id) {
        productDetailsPage.navigateToNonExistentProduct(id);
    }

    @Then("the page should handle it gracefully")
    public void thePageShouldHandleItGracefully() {
        MatcherAssert.assertThat(productDetailsPage.isPageStable(), Matchers.is(true));
    }

    @And("the application should not crash")
    public void theApplicationShouldNotCrash() {
        MatcherAssert.assertThat(productDetailsPage.isPageStable(), Matchers.is(true));
    }

    @Given("I am on the product details page")
    public void iAmOnTheProductDetailsPage() {
        productDetailsPage.open();
        productDetailsPage.acceptConsentIfVisible();
        homePage.dismissPopups();
    }

    @When("I enter a valid name {string}")
    public void iEnterAValidName(String name) {
        productDetailsPage.enterReviewName(name);
    }

    @And("I enter a valid email {string}")
    public void iEnterAValidEmail(String email) {
        productDetailsPage.enterReviewEmail(email);
    }

    @And("I enter a review message {string}")
    public void iEnterAReviewMessage(String message) {
        productDetailsPage.enterReviewMessage(message);
    }

    @And("I click the Submit Review button")
    public void iClickTheSubmitReviewButton() {
        productDetailsPage.clickSubmitReviewButton();
    }

    @Then("the review should be submitted successfully")
    public void theReviewShouldBeSubmittedSuccessfully() {
        MatcherAssert.assertThat(productDetailsPage.isReviewSubmittedSuccessfully(), Matchers.is(true));
    }

    @When("I leave the name field empty")
    public void iLeaveTheNameFieldEmpty() {
        productDetailsPage.enterReviewName("");
    }

    @Then("a required field validation message should appear")
    public void aRequiredFieldValidationMessageShouldAppear() {
        MatcherAssert.assertThat(productDetailsPage.getNameValidationMessage(), Matchers.containsString("Please fill in this field."));
    }

    @And("I enter an invalid email {string}")
    public void iEnterAnInvalidEmail(String email) {
        productDetailsPage.enterReviewEmail(email);
    }

    @Then("an invalid email validation message should appear")
    public void anInvalidEmailValidationMessageShouldAppear() {
        MatcherAssert.assertThat(productDetailsPage.getEmailValidationMessage(), Matchers.containsString("@"));
    }

    @Then("a malformed email validation message should appear")
    public void aMalformedEmailValidationMessageShouldAppear() {
        MatcherAssert.assertThat(productDetailsPage.getEmailValidationMessage(), Matchers.containsString("should not contain"));
    }
}
