package com.farhan;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeEach
    void setup(){
        driver=new ChromeDriver();

    }

//    @Test
//    void shouldOpenGoogle(){
//        driver.get("https://www.google.com");
//        System.out.println("Title: "+driver.getTitle());
//        Assertions.assertTrue(driver.getTitle().contains("Google"));
//    }
    @Test
    void shouldOpenSauceDemo(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String title=driver.findElement(By.className("title")).getText();
        Assertions.assertEquals("Products",title);
    }
    @Test
    void findingUsingCSS(){
        driver.get("https://www.saucedemo.com");
           WebElement userNameField= driver.findElement(By.cssSelector("#user-name"));
        System.out.println(userNameField.isDisplayed());
        System.out.println(userNameField.getAttribute("placeholder"));

        driver.findElement(By.cssSelector("#user-name")). sendKeys("standard_user");
     driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
     driver.findElement(By.cssSelector("#login-button")).click();
     String title=driver.findElement(By.cssSelector(".title")).getText();
     Assertions.assertEquals("Products",title);
     WebElement dropdown=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Price (low to high)");


        WebElement after= driver.findElement(By.className("product_sort_container"));
        Select afterSelect=new Select(after);
        System.out.println(afterSelect.getFirstSelectedOption().getText());
        List <WebElement> productNames=driver.findElements(By.xpath("//div[@class='inventory_item']"));
        for(WebElement product : productNames){
            System.out.println(product.getText());
        }
        driver.findElement(By.className("shopping_cart_container")).click();

    }
    @Test
    void findinUsingXpath(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String title=driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assertions.assertEquals("Products",title);
        int productCount=driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        Assertions.assertEquals(6,productCount);
    }

    @Test
    void checkingAlerts(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        String result=driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.println(result);
        Assertions.assertEquals("You successfully clicked an alert",result);
    }

    @Test
    void testing_demoqa(){
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//a[@href='/forms']")).click();
        driver.findElement(By.xpath("//a[@href='/automation-practice-form']")).click();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys("JohnDoe@mail.com");
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("0000000000");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
