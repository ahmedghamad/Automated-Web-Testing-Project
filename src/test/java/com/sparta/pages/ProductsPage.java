package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import java.util.List;

@DefaultUrl("https://automationexercise.com/products")
public class ProductsPage extends PageObject {

    @FindBy(css = "a[href='/products']")
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

    @FindBy(css = ".product-overlay .add-to-cart")
    private List<WebElementFacade> addToCartButtons;

    @FindBy(name = "search")
    private WebElementFacade searchBar;

    @FindBy(id = "submit_search")
    private WebElementFacade submitSearch;

    @FindBy(css = "button.fc-cta-consent")
    private WebElementFacade consentButton;

    @FindBy(css = ".features_items .col-sm-4")
    private List<WebElementFacade> productCards;


    public void acceptConsentIfVisible() {
            if (consentButton.isVisible()) {
                consentButton.click();
            }
    }

    public void clickProductsNavLink() {
        productsNavLink.click();
    }

    public String getPageHeading() {
        return allProductsHeading.getText().trim();
    }

    public boolean areProductsDisplayed() {
        return !productNames.isEmpty();
    }

    public boolean productsHaveNameAndPrice() {
        return !productNames.isEmpty() && !productPrices.isEmpty()
                && productNames.size() == productPrices.size();
    }

    public boolean allProductsHaveViewProductLink() {
        return !viewProductLinks.isEmpty();
    }

    public boolean isCategorySidebarVisible() {
        return categorySidebarHeading.isVisible();
    }

    public boolean isBrandsSidebarVisible() {
        return brandsSidebar.isVisible();
    }

    public boolean addToCartButtonsExist() {
        return !addToCartButtons.isEmpty();
    }

    public void enterSearchItem(String searchItem) {
        this.searchBar.type(searchItem);
    }

    public void clickSearch() {
        waitFor(submitSearch).isClickable();
        submitSearch.click();
    }

    public boolean areSearchResultsDisplayed() {
        return !productNames.isEmpty();
    }

    public boolean noProductsDisplayed() {
        return productCards.isEmpty();
    }

    public boolean isSearchBarVisible() {
        return searchBar.isVisible();
    }

    public boolean isPageStable() {
        return allProductsHeading.isVisible();
    }

    public void clearSearchBar() {
        searchBar.clear();
    }
}