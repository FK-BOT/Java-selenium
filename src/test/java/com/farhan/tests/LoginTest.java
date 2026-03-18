package com.farhan.tests;

import com.farhan.base.BaseTest;
import com.farhan.pages.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest extends BaseTest{
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeEach
    public void setUpPages(){
        driver.get("https://www.saucedemo.com");
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
    }

    @Test
    public void shouldLoginSuccessfully(){
        loginPage.login("standard_user","secret_sauce");
        assertTrue(productsPage.isProductsPageLoaded());
    }

    @Test
    public void shouldShowSixProducts(){
        loginPage.login("standard_user","secret_sauce");
        assertEquals(6,productsPage.getProductCount());
    }

    @Test
    public void invalidLogin(){
        loginPage.login("wrong_username","wrong_password");
        String error=loginPage.getErrorMessage();
        assertTrue(error.contains("Username and password do not match"));
    }

    @Test
    public void shouldShowErrorWhenUserNameEmpty(){
        loginPage.login("","secret_sauce");
        String error=loginPage.getErrorMessage();
        assertTrue(error.contains("Username is required"));
    }

}
