package Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 {

    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void retrieveEmergencyContacts() {
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        usernameField.sendKeys("orange");
        passwordField.sendKeys("orangepassword123");
        loginButton.click();
        WebElement emergencyContactsMenu = driver.findElement(By.id("menu_pim_viewMyDetails"));
        emergencyContactsMenu.click();
        WebElement contactsLink = driver.findElement(By.linkText("Emergency Contacts"));
        contactsLink.click();
        List<WebElement> contactRows = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));
        System.out.println("Emergency Contacts:");
        for (WebElement row : contactRows) {
            String name = row.findElement(By.xpath("./td[2]")).getText();
            String relationship = row.findElement(By.xpath("./td[3]")).getText();
            String homeTelephone = row.findElement(By.xpath("./td[4]")).getText();
            String mobile = row.findElement(By.xpath("./td[5]")).getText();

            System.out.println("Name: " + name + ", Relationship: " + relationship +
                               ", Home Telephone: " + homeTelephone + ", Mobile: " + mobile);
        }
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

