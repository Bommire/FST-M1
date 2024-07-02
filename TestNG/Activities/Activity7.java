package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void addQualifications() {
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        usernameField.sendKeys("orange");
        passwordField.sendKeys("orangepassword123");
        loginButton.click();
        WebElement myInfoMenu = driver.findElement(By.id("menu_pim_viewMyDetails"));
        myInfoMenu.click();
        WebElement qualificationsMenu = driver.findElement(By.id("suchi"));
        WebElement qualificationsLink = qualificationsMenu.findElement(By.linkText("Qualifications"));
        qualificationsLink.click();
        WebElement addWorkExpBtn = driver.findElement(By.id("addWorkExperience"));
        addWorkExpBtn.click();
        WebElement employerField = driver.findElement(By.id("experience_employer"));
        employerField.sendKeys("IBM Corp");
        WebElement jobTitleField = driver.findElement(By.id("experience_jobtitle"));
        jobTitleField.sendKeys("Software Engineer");
        WebElement fromDateField = driver.findElement(By.id("experience_from_date"));
        fromDateField.sendKeys("2021-01-01");
        WebElement toDateField = driver.findElement(By.id("experience_to_date"));
        toDateField.sendKeys("2024-06-30");
        WebElement workDescField = driver.findElement(By.id("experience_description"));
        workDescField.sendKeys("Responsible for developing and maintaining software applications.");
        WebElement saveBtn = driver.findElement(By.id("btnWorkExpSave"));
        saveBtn.click();
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


