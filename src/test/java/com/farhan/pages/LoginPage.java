package com.farhan.pages;
import org.openqa.selenium.*;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private By usenameField=By.id("user-name");
    private By passwordField=By.id("password");
    private By loginButton=By.id("login-button");
    private By errorMessage=By.cssSelector("[data-test='error']");

    public void enterUserName(String username){
        driver.findElement(usenameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public void login(String username,String password){
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

}
