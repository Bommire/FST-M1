package Activityes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {
    public static void main(String[] args) {
        
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
driver.get("https://v1.training-support.net/selenium/login-form");
System.out.println("Home page title: " + driver.getTitle());
driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Sucharitha");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pass2123");
driver.findElement(By.xpath("//button[text()='Log in']")).click();
String message = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
System.out.println("Login message: " + message);
driver.close();
    }
}

