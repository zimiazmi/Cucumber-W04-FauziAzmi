package com.juaracoding.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar {
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement burgerMenu;

    @FindBy(xpath = "//*[@id='inventory_sidebar_link']")
    WebElement allItems;

    @FindBy(xpath = "//*[@id='about_sidebar_link']")
    WebElement about;

    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    WebElement logOut;

    @FindBy(xpath = "//*[@id='reset_sidebar_link']")
    WebElement resetAppState;

    public SideBar(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickBurgerMenu(){
        burgerMenu.click();
    }

    public void clickLogOut(){
        logOut.click();
    }

}