package com.juaracoding.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckoutInformation {
    private Actions actions;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement checkoutInformationHeader;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement inputPostalCode;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//button[@id='cancel']")
    WebElement cancelButton;

    public CheckoutInformation(WebDriver driver){
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public String getCheckoutInformationHeader(){
        return checkoutInformationHeader.getText();
    }

    public void fillFirstName(String firstname){
        inputFirstName.sendKeys(firstname);
    }

    public void fillLastName(String lastname){
        inputLastName.sendKeys(lastname);
    }

    public void fillPostalCode(String postalcode){
        inputPostalCode.sendKeys(postalcode);
    }

    public void clickContinue(){
        continueButton.click();
    }

    public void clickCancel(){
        cancelButton.click();
    }

    public void checkoutInformationAction(String firstname, String lastname, String postalcode){
        actions.click(inputFirstName).sendKeys(firstname)
                .pause(Duration.ofSeconds(1))
                .click(inputLastName).sendKeys(lastname)
                .pause(Duration.ofSeconds(1))
                .click(inputPostalCode).sendKeys(postalcode)
                .pause(Duration.ofSeconds(1))
                .click(continueButton)
                .build().perform();
    }

    public WebElement getElemetInputFirstName(){
        return inputFirstName;
    }

    public WebElement getElemetButtonContinue(){
        return continueButton;
    }


}