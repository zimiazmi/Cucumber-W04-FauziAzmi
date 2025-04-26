package com.juaracoding.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutComplete {

    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement chekcoutCompleteHeader;

    @FindBy(xpath = "//*[@id='checkout_complete_container']/h2")
    WebElement successOrder;

    @FindBy(xpath = "//button[@id='back-to-products']")
    WebElement backToHome;

    public CheckOutComplete(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getCheckoutCompleteHeader(){
        return chekcoutCompleteHeader.getText();
    }

    public String getMessageSuccess(){
        return successOrder.getText();
    }

    public void clickBackToHome(){
        backToHome.click();
    }

    public WebElement getElementSuccessOrder(){
        return successOrder;
    }

}