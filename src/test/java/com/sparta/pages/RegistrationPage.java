package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/signup")
public class RegistrationPage extends PageObject {

    //Locators

    @FindBy(id = "id_gender1")
    private WebElementFacade mrTitleRadioButton;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(id = "first_name")
    private WebElementFacade firstName;

    @FindBy(id = "last_name")
    private WebElementFacade lastName;

    @FindBy(id = "address1")
    private WebElementFacade address;

    @FindBy(id = "country")
    private WebElementFacade countryDropDown;

    @FindBy(id = "state")
    private WebElementFacade state;

    @FindBy(id = "city")
    private WebElementFacade city;

    @FindBy(id = "zipcode")
    private WebElementFacade zipcode;

    @FindBy(id = "mobile_number")
    private WebElementFacade mobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElementFacade createAccountButton;


    //Action methods
    public void selectTitle() {

        this.mrTitleRadioButton.click();
    }

    public void enterPassword(String password) {
        this.password.type(password);
    }

    public void enterFirstName(String firstName) {
        this.firstName.type(firstName);
    }

    public void enterLastName(String lastName) {
        this.lastName.type(lastName);
    }

    public void enterAddress(String address) {
        this.address.type(address);
    }

    public void selectCountry(String country) {
        countryDropDown.selectByVisibleText(country);
    }

    public void enterState(String state) {
        this.state.type(state);
    }

    public void enterCity(String city) {
        this.city.type(city);
    }

    public void enterZipcode(String zipcode) {
        this.zipcode.type(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        this.mobileNumber.type(mobileNumber);
    }

    public void clickCreateAccount() {
        this.createAccountButton.click();
    }


}
