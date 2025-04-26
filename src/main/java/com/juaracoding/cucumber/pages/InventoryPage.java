package com.juaracoding.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    @FindBy (xpath = "//span[@class='title']")
    WebElement productHeader;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement buttonAddToCartSauceLabsBackpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    WebElement buttonAddToCartSauceLabsBikeLight;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    WebElement buttonAddToCartSauceLabsBoltTshirt;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement buttonAddToCartSauceLabsFleceJacket;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    WebElement buttonAddToCartSauceLabsOnesie;

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    WebElement buttonAddToCartSauceLabsTshirtRed;

    @FindBy(xpath = "//*[@id='shopping_cart_container']")
    WebElement cart;

    @FindBy(xpath = "//*[@class='shopping_cart_badge']")
    WebElement cartBadge;

    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getProductheader(){
        return productHeader.getText();
    }

    public void addToCart(WebElement element){
        element.click();
    }

    public String getCartBadge(){
        return cartBadge.getText();
    }

    public void navigateToCart(){
        cart.click();
    }

    public void addSauceLabBackpack(){
        buttonAddToCartSauceLabsBackpack.click();
    }

    public WebElement getElementSauceLabsBackpack(){
        return buttonAddToCartSauceLabsBackpack;
    }

}