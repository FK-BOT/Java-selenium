package com.farhan.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="user-name")
    private WebElement usenameField;
    @FindBy(id="password")
    private WebElement passwordField;
    @FindBy(id="login-button")
    private WebElement loginButton;
    @FindBy(css="[data-test='error']")
    private WebElement errorMessage;

    public void enterUserName(String username){
        usenameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickLogin(){
        loginButton.click();
    }
    public void login(String username,String password){
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
