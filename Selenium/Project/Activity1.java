package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
    public static void main(String[] args) {
    	WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("OrangeHRM")) {
            System.out.println("Website title is verified: " + pageTitle);
        } else {
            System.out.println("Website title verification failed. Actual title is: " + pageTitle);
        }
        driver.quit();
    }
}
