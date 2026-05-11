package com.sparta.steps;

import com.sparta.pages.CartPage;
import com.sparta.pages.HomePage;
import com.sparta.pages.ProductsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class CartSteps {

    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @And("the user navigates to the products page")
    public void theUserNavigatesToTheProductsPage() {

        productsPage.open();
    }

    @And("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {

        productsPage.clickAddToCartButton();
    }

    @And("the user clicks the View Cart button")
    public void theUserClicksTheViewCartButton() {

        productsPage.clickViewCartButton();
    }

    @Then("the product should be displayed in the cart")
    public void theProductShouldBeDisplayedInTheCart() {

        MatcherAssert.assertThat(
                cartPage.isProductDisplayedInCart(),
                Matchers.is(true)
        );
    }

    @And("the user clicks the Cart button")
    public void theUserClicksTheCartButton() {

        homePage.clickCartButton();
    }

    @Then("the shopping cart page should be displayed")
    public void theShoppingCartPageShouldBeDisplayed() {

        MatcherAssert.assertThat(
                cartPage.isShoppingCartDisplayed(),
                Matchers.is(true)
        );
    }

    @And("the user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {

        cartPage.clickRemoveProductButton();
    }

    @Then("the cart should display an empty cart message")
    public void theCartShouldDisplayAnEmptyCartMessage() {

        MatcherAssert.assertThat(
                cartPage.isCartEmptyMessageDisplayed(),
                Matchers.is(true)
        );
    }

    @Then("the product quantity should be {string}")
    public void theProductQuantityShouldBe(String expectedQuantity) {

        MatcherAssert.assertThat(
                cartPage.getProductQuantity(),
                Matchers.equalTo(expectedQuantity)
        );
    }

}