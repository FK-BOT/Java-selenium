package com.farhan.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CartPage {

    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(css="[data-test='shopping-cart-link']")
    private WebElement cartIcon;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String getCartCount(){
        return cartBadge.getText();
    }

    public void openCart(){
        cartIcon.click();
    }
    //    public void addFirstItemToCart(){
//        addToCart.click();
//    }
    public void addAllItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        int total = driver.findElements(
                By.xpath("//button[contains(@id,'add-to-cart')]")
        ).size();

        for (int i = 0; i < total; i++) {
            List<WebElement> buttons = driver.findElements(
                    By.xpath("//button[contains(@id,'add-to-cart')]")
            );
            WebElement button = buttons.get(0);
            String buttonId = button.getAttribute("id");
            System.out.println("Clicking: " + buttonId);
            button.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.id(buttonId)
            ));
        }
    }


}
