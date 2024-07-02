package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
    	WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        

    }

    @Test
    public void editUserInfo() {
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        usernameField.sendKeys("orange");
        passwordField.sendKeys("orangepassword123");
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement myInfoMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
        myInfoMenu.click();
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
        editButton.click();
        WebElement firstNameField = driver.findElement(By.id("personal_txtEmpFirstName"));
        firstNameField.clear();
        firstNameField.sendKeys("Suchi");
        WebElement lastNameField = driver.findElement(By.id("personal_txtEmpLastName"));
        lastNameField.clear();
        lastNameField.sendKeys("Reddy");
        WebElement genderDropdown = driver.findElement(By.id("personal_cmbGender"));
        genderDropdown.sendKeys("Male");
        WebElement nationalityField = driver.findElement(By.id("personal_cmbNation"));
        nationalityField.sendKeys("American");
        WebElement dobField = driver.findElement(By.id("personal_DOB"));
        dobField.clear();
        dobField.sendKeys("1999-05-10");
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message.success")));
        System.out.println("User information edited successfully.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


