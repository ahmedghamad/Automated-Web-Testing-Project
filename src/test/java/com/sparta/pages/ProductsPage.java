package com.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://automationexercise.com/products")
public class ProductsPage {

    @FindBy(css = "a[href='/prodcuts']")
    private WebElementFacade productsNavLink;

    @FindBy(css = "h2.title.text-center")
    private WebElementFacade allProductsHeading;

    @FindBy(css = ".productinfo.text-center p")
    private List<WebElementFacade> productNames;

    @FindBy(css = ".productinfo.text-center h2")
    private List<WebElementFacade> productPrices;

    @FindBy(css = "a[href*='/product_details/']")
    private List<WebElementFacade> viewProductLinks;

    @FindBy(css = ".left-sidebar h2")
    private WebElementFacade categorySidebarHeading;

    @FindBy(css = ".brands-name")
    private WebElementFacade brandsSidebar;

    public void clickProductNavLink() {
        productsNavLink.click();
    }

    public String getPageHeading() {
        return allProductsHeading.getText();
    }

    public boolean areProductsDisplayed() {
        return !productNames.isEmpty();
    }

    public boolean productPriceExist() {
        return !productPrices.isEmpty();
    }

    public boolean productsHaveNameAndPrice() {
        return areProductsDisplayed() && productPriceExist() &&
                productNames.size() == productPrices.size();
    }

    public boolean allProductsHaveViewProductLink() {
        return productNames.size() == viewProductLinks.size();
    }

    public boolean isCategorySidebarVisible() {
        return categorySidebarHeading.isVisible();
    }

    public boolean isBrandsSidebarVisible() {
        return brandsSidebar.isVisible();
    }
}
