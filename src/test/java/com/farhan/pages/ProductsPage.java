package com.farhan.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;
//    private By sortDropdown=By.className("product_sort_container");
    @FindBy(className = "shopping_cart_container")
    private WebElement cartIcon;
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartCount;





    public String getPageTitle(){
        return pageTitle.getText();
    }

    public int getProductCount(){
        return productNames.size();
    }



    public List<WebElement> getProductNames(){
        return productNames;
    }
    public void clickCart(){
        cartIcon.click();
    }
    public String cartCount(){
        return cartCount.getText();
    }





    public boolean isProductsPageLoaded(){
        return pageTitle.getText().equals("Products");
    }

}
