package com.juaracoding.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    @FindBy(xpath = "//*[@class='title']")
    WebElement yourCartHeader;

    @FindBy(xpath = "//*[@id='checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    private List<WebElement> cartItems;


    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getHeaderCart(){
        return yourCartHeader.getText();
    }

    public void checkout(){
        checkoutButton.click();
    }

    public int countItemInCart(){
        return cartItems.size();
    }


}