package com.sparta.pages;

import java.lang.Exception;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://automationexercise.com/")
public class HomePage extends PageObject {


    // Navigation Link
    @FindBy(css = "a[href='/']")
    private WebElementFacade homeLink;

    @FindBy(css = "a[href='/products']")
    private WebElementFacade InventoryLink;

    @FindBy(css = "a[href='/view_cart']")
    private WebElementFacade cartLink;

    @FindBy(css = "a[href='/login']")
    private WebElementFacade loginLink;

    @FindBy(css = "a[href='/logout']")
    private WebElementFacade logoutLink;

    @FindBy(css = "a[href='/contact_us']")
    private WebElementFacade contactUsLink;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElementFacade productLink;


    //Locators

    @FindBy(css = "button.fc-cta-consent")
    private WebElementFacade consentButton;

    @FindBy(css = "a[href='/login']")
    private WebElementFacade signupLoginButton;

    @FindBy(css = ".features_items")
    private WebElementFacade featuresItemsSection;

    @FindBy(css=".panel:nth-child(1) > .panel-heading a")
    private WebElementFacade categorySection;

    //Brands panel
    @FindBy(css=".brands-name")
    private WebElementFacade brandsSection;

    @FindBy(css=".nav-pills > li:nth-child(7) > a")
    private WebElementFacade kookieKidsBrand;

    //Feature Item

    @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > " +
            "div.features_items > div:nth-child(3) > div > div.choose > ul > li > a")
    private WebElementFacade firstFeatureItem;


    // Category
    //Women

    @FindBy(css= "#Women > .panel-body")
    private WebElementFacade womenPanel;

    @FindBy(css=".panel:nth-child(1) > .panel-heading a")
    private WebElementFacade womenCategory;


    @FindBy (css = "#Women li:nth-child(1) > a")
    private WebElementFacade dressCategory;

    @FindBy (css = "#Women > div > ul > li:nth-child(2)")
    private WebElementFacade topsCategory;

    @FindBy (css = "#Women > div > ul > li:nth-child(3)")
    private WebElementFacade sareeCategory;

    @FindBy(css = ".col-sm-4:nth-child(3) .choose a")
    private  WebElementFacade firstDress;


    //men
    @FindBy(css = "#accordian > div:nth-child(2)")
    private WebElementFacade menCategory;

    @FindBy (xpath ="//*[@id=\"Men\"]/div/ul/li[1]")
    private WebElementFacade tShirtsCategory;

    @FindBy (xpath ="//*[@id=\"Men\"]/div/ul/li[2]")
    private WebElementFacade jeansCategory;

    //kids
    @FindBy(xpath = "//*[@id=\"accordian\"]/div[3]/div[1]/h4")
    private WebElementFacade kidsCategory;

    @FindBy(xpath =  "//*[@id=\"accordian\"]/div[3]/div[1]/h4/a")
    private WebElementFacade kidsDressCategory;

    @FindBy(xpath =  "//*[@id=\"Kids\"]/div/ul/li[2]/a")
    private WebElementFacade kidsTopsCategory;

    //After login validation locator

    @FindBy(xpath = "//b[normalize-space()='Test_User']")
    private WebElementFacade loggedInAsText;


    //Action methods

    // Brands Action
    public  void clickKookieKids(){
        kookieKidsBrand.click();
    }

//Womens Actions
    public void clickWomensCategory(){
        womenCategory.click();
    }

    public void  clickDress(){
        dressCategory.click();

    }

    public void viewProduct(){
        evaluateJavascript("arguments[0].scrollIntoView(true);", womenCategory);
        evaluateJavascript("arguments[0].click();", womenCategory);

        evaluateJavascript("arguments[0].scrollIntoView(true);", dressCategory);
        evaluateJavascript("arguments[0].click();", dressCategory);

        evaluateJavascript("arguments[0].scrollIntoView(true);", firstDress);
        evaluateJavascript("arguments[0].click();", firstDress);


    }

    public void clickTops(){
        topsCategory.click();
    }

    public void clickSaree(){
        sareeCategory.click();
    }

// Mens Action
    public void clickMensCategory(){
        menCategory.click();
    }

    public void clickTShirts(){
        topsCategory.click();
    }
    public void clickJeans(){
        jeansCategory.click();
    }

    //Navigation Bar Actions

    public  void clickHomeLink(){
        homeLink.click();
    }

    public  void clickProductLink(){
        productLink.click();
    }

    public  void clickCartLink(){
        cartLink.click();
    }

    public  void clickLoginLink(){
        loginLink.click();
    }

    public  void clickContactUsLink(){
        contactUsLink.click();
    }


    // Kids Action
    public void clickKidsCategory(){
        kidsCategory.click();
    }


    //  Checking Visibility on the page
    public boolean isCategorySectionVisible(){
        return categorySection.isVisible();
    }

    public boolean isFeaturedItemsVisible() {
        return featuresItemsSection.isVisible() ;
    }

    public boolean isWomenPanelVisible(){
        return womenPanel.isVisible();
    }

    public  boolean isBrandsPanelVisible(){
        return  brandsSection.isVisible();
    }


    public void clickFirstFeatureItem(){
        firstFeatureItem.click();
    }

    public  boolean  isNavigationVisible(){
        return homeLink.isVisible()&&
                productLink.isVisible()&&
                cartLink.isVisible()&&
                loginLink.isVisible()&&
                contactUsLink.isVisible();
    }



    public void dismissPopups() {

        // REMOVE GOOGLE ADS IFRAMES
        try {
            getDriver().findElements(By.cssSelector("iframe[id^='aswift_']")).forEach(f -> {
                try { evaluateJavascript("arguments[0].remove();", f); } catch (Exception ignored) {}
            });
        } catch (Exception ignored) {}

        // REMOVE GOOGLE ADS HOST DIVS
        try {
            getDriver().findElements(By.cssSelector("div[id^='aswift_'][id$='_host']")).forEach(d -> {
                try { evaluateJavascript("arguments[0].remove();", d); } catch (Exception ignored) {}
            });
        } catch (Exception ignored) {}



        // DISMISS CONSENT POPUP
        try {
            WebElementFacade popup = find(By.cssSelector(".fc-consent-root"));
            if (popup.isVisible()) {
                try {
                    WebElementFacade btn = popup.find(By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button"));
                    if (btn.isVisible() && btn.isClickable()) btn.click();
                    else evaluateJavascript("arguments[0].click();", btn);
                } catch (Exception ignored) {}
                try { evaluateJavascript("arguments[0].remove();", popup); } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
    }

    // Remove google vignette overlay
    public void dissmissGoogleVignette(){

        try {
            WebElementFacade vignette = find(By.cssSelector("#google_vignette"));
            if (vignette.isPresent()) {
                evaluateJavascript("document.querySelector('#google_vignette').remove();");
            }
        } catch (Exception ignored) {}
    }

        public void clickSignupLoginButton() {
        signupLoginButton.click();
    }

    public boolean isLoggedInAsTextDisplayed() {
        return loggedInAsText.isDisplayed();
    }

    public void acceptConsentIfVisible() {
        try {
            if (consentButton.isVisible()) {
                consentButton.click();
            }
        } catch (Exception  e) {
            System.out.println("Consent popup not displayed");
        }
    }



}
