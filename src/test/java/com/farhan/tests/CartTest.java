package com.farhan.tests;
import com.farhan.base.BaseTest;
import com.farhan.pages.LoginPage;
import com.farhan.pages.CartPage;
import org.junit.jupiter.api.*;
import com.farhan.utils.ScreenshotUtil;

public class CartTest extends BaseTest{

    @AfterEach
    void captureScreenShot(TestInfo testInfo){
        ScreenshotUtil.takeScreenShot(driver,testInfo.getDisplayName());
    }

    @Test
    @DisplayName("login add to cart and verifyCount")
    void loginAddToCartAndVerify(){
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        CartPage cartPage=new CartPage(driver);
        cartPage.addAllItems();


        System.out.println(cartPage.getCartCount());
        Assertions.assertEquals("6",cartPage.getCartCount());
//        Assertions.assertEquals("6",cartPage.getCartCount());

    }


}
