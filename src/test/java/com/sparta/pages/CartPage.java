package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
@DefaultUrl("https://automationexercise.com/view_cart")
public class CartPage { @FindBy(xpath = "//li[@class='active']")
private WebElementFacade shoppingCartText;

    @FindBy(xpath = "//td[@class='cart_description']")
    private WebElementFacade cartProduct;

    @FindBy(className = "cart_quantity_delete")
    private WebElementFacade removeProductButton;

    @FindBy(xpath = "//*[contains(text(),'Cart is empty')]")
    private WebElementFacade emptyCartMessage;


    @FindBy(xpath = "//button[@disabled]")
    private WebElementFacade productQuantity;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    private WebElementFacade proceedToCheckoutButton;

    public boolean isShoppingCartDisplayed() {
        return shoppingCartText.isDisplayed();
    }

    public boolean isProductDisplayedInCart() {
        return cartProduct.isDisplayed();
    }

    public void clickRemoveProductButton() {
        removeProductButton.click();
    }

    public boolean isCartEmptyMessageDisplayed() {
        return emptyCartMessage.isDisplayed();
    }


    public String getProductQuantity() {
        return productQuantity.getText();
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

}


