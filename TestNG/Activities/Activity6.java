package Activitys;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void beforeClass() {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, null);
	        driver.get("https://v1.training-support.net/selenium/login-form");
	    }
	    
	    @Test
	    @Parameters({"username", "password"})
	    public void loginTestCase(String username, String password) {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));    
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        driver.findElement(By.cssSelector("button[type='submit']")).click();
	        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	        Assert.assertEquals(loginMessage, "Welcome Back, admin");
	    }

	    @AfterClass
	    public void afterClass() {
	        driver.close();
	    }

	}
