package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;

    By accounts = By.xpath("//a[@id='nav-link-accountList']");
    By username = By.xpath("//input[@id='ap_email']");
    By continue_sign = By.id("continue");
    By password = By.xpath("//input[@id='ap_password']");
    By sign_in_button = By.id("signInSubmit");

    LoginPage(WebDriver d) {
        driver = d;
    }

    public void accounts() {
        driver.findElement(accounts).click();
    }

    public void username(String uname) {
        driver.findElement(username).sendKeys(uname);
    }

    public void continue_sign() {
        driver.findElement(continue_sign).click();
    }

    public void password(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void sign_in_button() {
        driver.findElement(sign_in_button).click();
    }
}
