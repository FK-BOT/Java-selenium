package com.farhan.pages;
import org.openqa.selenium.*;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }

    private By pageTitle=By.className("title");
    private By productNames=By.className("inventory_item_name");
//    private By sortDropdown=By.className("product_sort_container");
    private By cartIcon=By.className("Shopping_cart_container");
    private By cartCount=By.className("shoppimg_cart_badge");

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }

    public int getProductCount(){
        return driver.findElements(productNames).size();
    }

    public List<WebElement> getProductNames(){
        return driver.findElements(productNames);
    }
    public void clickCart(){
        driver.findElement(cartIcon).click();
    }
    public String cartCount(){
        return driver.findElement(cartCount).getText();
    }
    public boolean isProductsPageLoaded(){
        return driver.findElement(pageTitle).getText().equals("Products");
    }

}
