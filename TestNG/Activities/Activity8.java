package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void applyForLeave() {
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        usernameField.sendKeys("orange");
        passwordField.sendKeys("orangepassword123");
        loginButton.click();
        WebElement dashboardMenu = driver.findElement(By.id("menu_dashboard_index"));
        dashboardMenu.click();

        WebElement applyLeaveLink = driver.findElement(By.linkText("Apply Leave"));
        applyLeaveLink.click();
        WebElement leaveTypeDropdown = driver.findElement(By.id("applyleave_txtLeaveType"));
        leaveTypeDropdown.sendKeys("Paid Leave");
        WebElement fromDateField = driver.findElement(By.id("applyleave_txtFromDate"));
        fromDateField.clear();
        fromDateField.sendKeys("2024-07-01");
        WebElement toDateField = driver.findElement(By.id("applyleave_txtToDate"));
        toDateField.clear();
        toDateField.sendKeys("2024-07-03");
        WebElement applyButton = driver.findElement(By.id("applyBtn"));
        applyButton.click();
        WebElement myLeaveMenu = driver.findElement(By.id("menu_leave_viewMyLeaveList"));
        myLeaveMenu.click();
        try {
            Thread.sleep(10000); 
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

