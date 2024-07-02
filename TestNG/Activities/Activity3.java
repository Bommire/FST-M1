package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {

    public static void main(String[] args) {
    	WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        usernameField.sendKeys("orange");
        passwordField.sendKeys("orangepassword123");
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, null);
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/dashboard")) {
            System.out.println("Login successful. Homepage opened.");
        } else {
            System.out.println("Login failed. Homepage not opened.");
        }
        driver.close();
    }
}

