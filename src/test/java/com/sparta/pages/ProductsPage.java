package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;

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

    @FindBy(css = ".features_items a[href*='/product_details/']")
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

    @FindBy(css = "a[href='#Women']")
    private WebElementFacade womenCategory;

    @FindBy(css = "a[href='#Men']")
    private WebElementFacade menCategory;

    @FindBy(css = "a[href='#Kids']")
    private WebElementFacade kidsCategory;

    @FindBy(xpath = "//a[contains(@href,'/category_products/') and normalize-space()='Tops']")
    private WebElementFacade topsSubcategory;

    @FindBy(xpath = "//a[contains(@href,'/category_products/') and normalize-space()='Jeans']")
    private WebElementFacade jeansSubcategory;

    @FindBy(xpath = "//div[@id='Kids']//a[normalize-space()='Dress']")
    private WebElementFacade kidsDressSubcategory;

    @FindBy(xpath = "//div[@id='Women']//a[normalize-space()='Dress']")
    private WebElementFacade womenDressSubcategory;

    @FindBy(css = ".features_items h2.title")
    private WebElementFacade categoryPageHeading;

    @FindBy(css = ".features_items .col-sm-4")
    private WebElementFacade firstProduct;

    @FindBy(css = ".features_items .add-to-cart")
    private WebElementFacade firstProductAddToCart;

    @FindBy(css = ".modal-content")
    private WebElementFacade cartModal;

    @FindBy(css = ".modal-body p")
    private WebElementFacade modalMessage;

    @FindBy(css = ".modal-footer button")
    private WebElementFacade continueShoppingButton;

    @FindBy(css = ".modal-body a[href='/view_cart']")
    private WebElementFacade viewCartButton;

    @FindBy(css = "#cart_info_table tbody tr")
    private List<WebElementFacade> cartRows;

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
        evaluateJavascript("arguments[0].scrollIntoView(true);", submitSearch);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", submitSearch);
    }

    public boolean areSearchResultsDisplayed() {
        return !productNames.isEmpty();
    }

    public boolean noProductsDisplayed() {
        return productCards.isEmpty();
    }

    public boolean isPageStable() {
        return allProductsHeading.isVisible();
    }

    public void clearSearchBar() {
        searchBar.clear();
    }

    public void clickCategoryInSidebar(String category) {
        switch (category) {
            case "Women" -> womenCategory.click();
            case "Men"   -> menCategory.click();
            case "Kids"  -> kidsCategory.click();
        }
    }

    public void clickSubcategory(String subcategory) {
        switch (subcategory) {
            case "Tops"  -> {
                waitFor(topsSubcategory).isVisible();
                topsSubcategory.click();
            }
            case "Jeans" -> {
                waitFor(jeansSubcategory).isVisible();
                jeansSubcategory.click();
            }
            case "Dress" -> {
                waitFor(kidsDressSubcategory).isVisible();
                kidsDressSubcategory.click();
            }
        }
    }

    public String getCategoryPageHeading() {
        return categoryPageHeading.getText().trim();
    }

    public boolean atLeastOneProductDisplayed() {
        return !productCards.isEmpty();
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public boolean isOnProductsPage() {
        return getDriver().getCurrentUrl().contains("/products");
    }

    public void hoverOverFirstProduct() {
        withAction().moveToElement(firstProduct).perform();
    }

    public void clickAddToCartOnFirstProduct() {
        evaluateJavascript("arguments[0].scrollIntoView(true);", firstProductAddToCart);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", firstProductAddToCart);
    }

    public boolean isCartModalVisible() {
        try {
            waitFor(cartModal).waitUntilVisible();
            return cartModal.isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public String getModalMessage() {
        return modalMessage.getText().trim();
    }

    public boolean isContinueShoppingButtonVisible() {
        return continueShoppingButton.isVisible();
    }

    public boolean isViewCartButtonVisible() {
        return viewCartButton.isVisible();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public void clickViewCartInModal() {
        waitFor(viewCartButton).waitUntilClickable();
        viewCartButton.click();
    }

    public boolean isOnCartPage() {
        waitForCondition().until(
                driver -> driver.getCurrentUrl().contains("/view_cart")
        );
        return getDriver().getCurrentUrl().contains("/view_cart");
    }

    public boolean isCartNotEmpty() {
        return !cartRows.isEmpty();
    }
}