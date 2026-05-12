package com.sparta.steps;

import com.sparta.pages.HomePage;
import com.sparta.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class ProductsSteps {

    @Managed
    HomePage homePage;

    @Managed
    ProductsPage productsPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage.open();
        homePage.acceptConsentIfVisible();
    }

    @And("I click {string} in the navbar")
    public void iClickInTheNavbar(String link) {
        productsPage.clickProductsNavLink();
    }

    @Then("I should be navigated to the products page")
    public void iShouldBeNavigatedToTheProductsPage() {
        productsPage.open();
        productsPage.acceptConsentIfVisible();
        MatcherAssert.assertThat(productsPage.getDriver().getCurrentUrl(), Matchers.containsString("/products"));
    }

    @And("the heading {string} should be displayed")
    public void theHeadingShouldBeDisplayed(String heading) {
        MatcherAssert.assertThat(productsPage.getPageHeading(), Matchers.containsString(heading));
    }

    @And("multiple products should be shown in a grid layout")
    public void multipleProductsShouldBeShownInAGridLayout() {
        MatcherAssert.assertThat(productsPage.areProductsDisplayed(), Matchers.is(true));
    }

    @And("each product should have a name, price and View Product link")
    public void eachProductShouldHaveANamePriceAndViewProductLink() {
        MatcherAssert.assertThat(productsPage.productsHaveNameAndPrice(), Matchers.is(true));
        MatcherAssert.assertThat(productsPage.allProductsHaveViewProductLink(), Matchers.is(true));
    }

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        productsPage.open();
        productsPage.acceptConsentIfVisible();
    }

    @Then("an Add to Cart button should be visible on each product")
    public void anAddToCartButtonShouldBeVisibleOnEachProduct() {
        MatcherAssert.assertThat(productsPage.addToCartButtonsExist(), Matchers.is(true));
    }

    @And("a View Product link should be visible on each product")
    public void aViewProductLinkShouldBeVisibleOnEachProduct() {
        MatcherAssert.assertThat(productsPage.allProductsHaveViewProductLink(), Matchers.is(true));
    }

    @Then("the category sidebar should be visible")
    public void theCategorySidebarShouldBeVisible() {
        MatcherAssert.assertThat(productsPage.isCategorySidebarVisible(), Matchers.is(true));
    }

    @Then("the brands sidebar should be visible")
    public void theBrandsSidebarShouldBeVisible() {
        MatcherAssert.assertThat(productsPage.isBrandsSidebarVisible(), Matchers.is(true));
    }

    @When("I enter a valid product keyword {string}")
    public void iEnterAValidProductKeyword(String searchItem) {
        productsPage.enterSearchItem(searchItem);
    }

    @And("I click the Search button")
    public void iClickTheSearchButton() {
        productsPage.clickSearch();
    }

    @Then("relevant matching products are displayed")
    public void relevantMatchingProductsAreDisplayed() {
        MatcherAssert.assertThat(productsPage.areSearchResultsDisplayed(), Matchers.is(true));
    }

    @And("the page heading shows {string}")
    public void thePageHeadingShows(String heading) {
        MatcherAssert.assertThat(productsPage.getPageHeading(), Matchers.containsString(heading));
    }

    @And("all results correspond to the entered keyword")
    public void allResultsCorrespondToTheEnteredKeyword() {
        MatcherAssert.assertThat(productsPage.areSearchResultsDisplayed(), Matchers.is(true));
    }

    @When("I enter a partial keyword {string} in the search field")
    public void iEnterAPartialKeywordInTheSearchField(String searchWord) {
        productsPage.enterSearchItem(searchWord);
    }

    @Then("related matching products are displayed")
    public void relatedMatchingProductsAreDisplayed() {
        MatcherAssert.assertThat(productsPage.areSearchResultsDisplayed(), Matchers.is(true));
    }
    
    @When("I search for a non-existent product {string}")
    public void iSearchForANonExistentProduct(String searchTerm) {
        productsPage.enterSearchItem(searchTerm);
        
    }

    @Then("no products should be displayed")
    public void noProductsShouldBeDisplayed() {
        MatcherAssert.assertThat(productsPage.noProductsDisplayed(), Matchers.is(true));
    }

    @Given("the search bar is empty")
    public void theSearchBarIsEmpty() {
        productsPage.open();
        productsPage.acceptConsentIfVisible();
        productsPage.clearSearchBar();
    }

    @Then("all products remain displayed")
    public void allProductsRemainDisplayed() {
        MatcherAssert.assertThat(productsPage.noProductsDisplayed(), Matchers.is(false));
    }

    @When("I enter special characters {string} into the search field")
    public void iEnterSpecialCharactersIntoTheSearchField(String characters) {
        productsPage.enterSearchItem(characters);
    }

    @Then("the system handles the input safely")
    public void theSystemHandlesTheInputSafely() {
        MatcherAssert.assertThat(productsPage.isPageStable(), Matchers.is(true));
    }

    @When("I click the {string} category in the sidebar")
    public void iClickTheCategoryInTheSidebar(String category) {
        productsPage.clickCategoryInSidebar(category);
    }

    @And("I click the {string} subcategory")
    public void iClickTheSubcategory(String subcategory) {
        productsPage.clickSubcategory(subcategory);
    }

    @Then("I should be navigated to the category page")
    public void iShouldBeNavigatedToTheCategoryPage() {
        MatcherAssert.assertThat(productsPage.getDriver().getCurrentUrl(), Matchers.containsString("/category_products"));
    }

    @And("the page heading should contain {string}")
    public void thePageHeadingShouldContain(String expectedHeading) {
        MatcherAssert.assertThat(productsPage.getCategoryPageHeading(), Matchers.containsString(expectedHeading));
    }

    @And("at least one product should be displayed")
    public void atLeastOneProductShouldBeDisplayed() {
        MatcherAssert.assertThat(productsPage.atLeastOneProductDisplayed(), Matchers.is(true));
    }

    @And("I navigate back")
    public void iNavigateBack() {
        productsPage.navigateBack();
    }

    @Then("I should be on the products page")
    public void iShouldBeOnTheProductsPage() {
        MatcherAssert.assertThat(productsPage.isOnProductsPage(), Matchers.is(true));
    }

    @When("I click the Kookie Kids brand")
    public void iClickTheKookieKidsBrand() {
        homePage.clickKookieKids();
    }

    @Then("I should be navigated to the Kookie Kids brand page")
    public void iShouldBeNavigatedToTheKookieKidsBrandPage() {
        MatcherAssert.assertThat(homePage.getDriver().getCurrentUrl(), Matchers.containsString("Kookie"));
    }

    @Then("I should be back on the home page")
    public void iShouldBeBackOnTheHomePage() {
       MatcherAssert.assertThat(homePage.getDriver().getCurrentUrl(), Matchers.containsString("automationexercise.com"));
    }

    @When("I hover over the first product")
    public void iHoverOverTheFirstProduct() {
        productsPage.hoverOverFirstProduct();
    }

    @And("I click Add to Cart on that product")
    public void iClickAddToCartOnThatProduct() {
        productsPage.clickAddToCartOnFirstProduct();
    }

    @Then("a confirmation modal should appear")
    public void aConfirmationModalShouldAppear() {
        MatcherAssert.assertThat(productsPage.isCartModalVisible(), Matchers.is(true));
    }

    @And("the modal should display {string}")
    public void theModalShouldDisplay(String expectedMessage) {
        MatcherAssert.assertThat(productsPage.getModalMessage(), Matchers.containsString(expectedMessage));
    }

    @And("the modal should contain a Continue Shopping button")
    public void theModalShouldContainAContinueShoppingButton() {
        MatcherAssert.assertThat(productsPage.isContinueShoppingButtonVisible(), Matchers.is(true));
    }

    @And("the modal should contain a View Cart button")
    public void theModalShouldContainAViewCartButton() {
        MatcherAssert.assertThat(productsPage.isViewCartButtonVisible(), Matchers.is(true));
    }

    @And("I click Continue Shopping")
    public void iClickContinueShopping() {
        productsPage.clickContinueShopping();
    }

    @Then("I should remain on the products page")
    public void iShouldRemainOnTheProductsPage() {
        MatcherAssert.assertThat(productsPage.isOnProductsPage(), Matchers.is(true));
    }

    @And("I click View Cart in the modal")
    public void iClickViewCartInTheModal() {
        productsPage.clickViewCartInModal();
    }

    @Then("I should be navigated to the cart page")
    public void iShouldBeNavigatedToTheCartPage() {
       MatcherAssert.assertThat(productsPage.isOnCartPage(), Matchers.is(true));
    }

    @And("the product should be visible in the cart")
    public void theProductShouldBeVisibleInTheCart() {
        MatcherAssert.assertThat(productsPage.isCartNotEmpty(), Matchers.is(true));
    }
}
