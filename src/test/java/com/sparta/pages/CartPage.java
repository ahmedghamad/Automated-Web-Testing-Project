package com.sparta.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("https://automationexercise.com/view_cart")
public class CartPage extends PageObject {


    // Locators
    @FindBy(className = "cart_quantity")
    private WebElementFacade cartQuantity;

    @FindBy(className = "cart_quantity_delete")
    private WebElementFacade cartQuantityDelete;

    @FindBy(className = "text-center")
    private WebElementFacade textCenter;

    @FindBy(css = ".check_out")
    private WebElementFacade toCheckout;

    @FindBy(partialLinkText = "Register")
    private WebElementFacade toLogin;

    public String getCartQuantity() {
        return cartQuantity.getText();
    }

    public String emptyCartMessage() {
        return textCenter.getText();
    }

    public void cartQuantityDelete() {
        cartQuantityDelete.click();
    }

    public void proceedToCheckout() {
        toCheckout.click();
    }

    public void toLogin() {
        toLogin.click();
    }

}
