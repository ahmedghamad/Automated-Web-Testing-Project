package com.sparta.steps;

import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.Optional;

import com.sparta.pages.HomePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

public class HomeSteps {
    @Managed
    HomePage homePage;



    @Given("the shopper navigates to the home page")
    public void theShopperNavigatesToTheHomePage() {
        homePage.open();
        homePage.acceptConsentIfVisible();
        homePage.dismissPopups();
        MatcherAssert.assertThat(homePage.getDriver().getCurrentUrl(), Matchers.is("https://automationexercise.com/"));


    }

    @Then("the featured items section should be visible")
    public void theFeaturedItemsSectionShouldBeVisible() {
        Assertions.assertTrue(homePage.isFeaturedItemsVisible());
    }

    @And("the featured items should be accessible")
    public void theFeaturedItemsShouldBeAccessible() {
        homePage.clickFirstFeatureItem();
        MatcherAssert.assertThat(homePage.getDriver().getCurrentUrl(), Matchers.is("https://automationexercise.com/product_details/1"));
    }

    @Then("the category filter should be visible")
    public void theCategoryFilterShouldBeVisible() {
        homePage.dismissPopups();
        Assertions.assertTrue( homePage.isCategorySectionVisible());

    }

    @And("the category filter should be accessible")
    public void theCategoryFilterShouldBeAccessible() {
        homePage.clickWomensCategory();
        Assertions.assertTrue(homePage.isWomenPanelVisible());
        homePage.clickDress();
    }

    @Then("the brands filter should be visible")
    public void theBrandsFilterShouldBeVisible() {
      Assertions.assertTrue(homePage.isBrandsPanelVisible());
    }

    @And("the brands filter should be accessible")
    public void theBrandsFilterShouldBeAccessible() {
        homePage.clickKookieKids();
        MatcherAssert.assertThat(homePage.getDriver().getCurrentUrl(), Matchers.is("https://automationexercise.com/brand_products/Kookie%20Kids"));
    }

    @Then("the navigation bar should be visible")
    public void theNavigationBarShouldBeVisible() {
        Assertions.assertTrue(homePage.isNavigationVisible());
    }

    @And("the navigation bar should be accessible")
    public void theNavigationBarShouldBeAccessible() {
      homePage.clickCartLink();
      MatcherAssert.assertThat(homePage.getDriver().getCurrentUrl(),Matchers.is("https://automationexercise.com/view_cart"));
    }


}
