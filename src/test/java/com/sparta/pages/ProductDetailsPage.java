package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/product_details/1")
public class ProductDetailsPage extends PageObject {

    @FindBy(css = ".product-information h2")
    private WebElementFacade productName;

    @FindBy(css = ".product-information span span")
    private WebElementFacade productPrice;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(., 'Category:')]")
    private WebElementFacade productCategory;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(., 'Brand:')]")
    private WebElementFacade productBrand;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(., 'Availability:')]")
    private WebElementFacade productAvailability;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(., 'Condition:')]")
    private WebElementFacade productCondition;

    @FindBy(css = "#product-detail-section img.view-product")
    private WebElementFacade productImage;

    @FindBy(css = "div.view-product img")
    private WebElementFacade productDetailImage;

    @FindBy(id = "quantity")
    private WebElementFacade quantityField;

    @FindBy(css = "button.cart")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".category-tab.shop-details-tab")
    private WebElementFacade writeReviewSection;

    @FindBy(css = "a[href*='/product_details/']")
    private WebElementFacade viewProductLink;

    @FindBy(css = "button.fc-cta-consent")
    private WebElementFacade consentButton;

    @FindBy(id = "name")
    private WebElementFacade reviewNameField;

    @FindBy(id = "email")
    private WebElementFacade reviewEmailField;

    @FindBy(id = "review")
    private WebElementFacade reviewTextField;

    @FindBy(id = "button-review")
    private WebElementFacade submitReviewButton;

    @FindBy(css = "#review-section .alert-success")
    private WebElementFacade reviewSuccessMessage;

    public void acceptConsentIfVisible() {
        try {
            if (consentButton.isVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {
            System.out.println("Consent not visible");
        }
    }

    public boolean isProductNameDisplayed() {
        return productName.isVisible();
    }

    public boolean isProductPriceDisplayed() {
        return productPrice.isVisible();
    }

    public boolean isProductCategoryDisplayed() {
        return productCategory.isVisible();
    }

    public boolean isProductBrandDisplayed() {
        return productBrand.isVisible();
    }

    public boolean isProductAvailabilityDisplayed() {
        return productAvailability.isVisible();
    }

    public boolean isProductConditionDisplayed() {
        return productCondition.isVisible();
    }

    public boolean isProductImageDisplayed() {
        try {
            return productDetailImage.isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isQuantityFieldVisible() {
        return quantityField.isVisible();
    }

    public String getQuantityValue() {
        return quantityField.getValue();
    }

    public boolean isAddToCartButtonVisible() {
        return addToCartButton.isVisible();
    }

    public boolean isAddToCartButtonEnabled() {
        return addToCartButton.isEnabled();
    }

    public boolean isWriteReviewSectionVisible() {
        return writeReviewSection.isVisible();
    }

    public boolean isOnProductDetailsPage() {
        return getDriver().getCurrentUrl().contains("/product_details/");
    }

    public boolean isPageStable() {
        try {
            return !getDriver().findElements(By.cssSelector("body")).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateToNonExistentProduct(int id) {
        getDriver().navigate().to(
                "https://automationexercise.com/product_details/" + id
        );
    }

    public void enterReviewName(String name) {
        reviewNameField.type(name);
    }

    public void enterReviewEmail(String email) {
        reviewEmailField.type(email);
    }

    public void enterReviewMessage(String message) {
        reviewTextField.type(message);
    }

    public void clickSubmitReviewButton() {
        submitReviewButton.click();
    }

    public boolean isReviewSubmittedSuccessfully() {
        try {
            waitFor(reviewSuccessMessage).waitUntilVisible();
            return reviewSuccessMessage.isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public String getNameValidationMessage() {
        return reviewNameField.getAttribute("validationMessage");
    }

    public String getEmailValidationMessage() {
        return reviewEmailField.getAttribute("validationMessage");
    }
}
