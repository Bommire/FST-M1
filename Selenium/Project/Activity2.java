package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
    public static void main(String[] args) {
    	WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement headerImage = driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));
        String imageUrl = headerImage.getAttribute("src");
        System.out.println("URL of the header image: " + imageUrl);
        driver.close();
    }
}

