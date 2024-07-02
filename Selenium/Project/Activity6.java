package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
    	WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyDirectoryMenuItem() {
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        usernameField.sendKeys("orange");
        passwordField.sendKeys("orangepassword123");
        loginButton.click();
        try {
            WebElement directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));
            if (directoryMenu.isDisplayed() && directoryMenu.isEnabled()) {
                System.out.println("Directory menu item is visible and clickable.");
                directoryMenu.click();
                WebElement pageHeading = driver.findElement(By.xpath("//h1[contains(text(), 'Search Directory')]"));
                if (pageHeading.isDisplayed()) {
                    System.out.println("Page heading matches: " + pageHeading.getText());
                } else {
                    System.out.println("Page heading is not visible.");
                }
            } else {
                System.out.println("Directory menu item is not visible or clickable.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

