package com.farhan;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WaitsTest {
    WebDriver driver;

    @BeforeEach
    void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }
    @Test
    void implicitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        String text = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        Assertions.assertEquals("Hello World!", text);
        //will fail
    }

    @Test
    void explicitTest(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement finish= wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4"))
        );
        String text= finish.getText();
        Assertions.assertEquals("Hello World!",text);
    }
    @Test
    void fluentWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        Wait<WebDriver> fluent= new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement finish=fluent.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4"))
        );
        Assertions.assertEquals("Hello World!",finish.getText());
    }


    @AfterEach
    void tearDown(){
        driver.quit();
    }
}