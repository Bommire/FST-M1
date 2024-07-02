package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {

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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule")));
        pimMenu.click();
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd")));
        addButton.click();
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        firstNameField.sendKeys("Sucharitha");
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Bommireddy");
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message.success")));
        System.out.println("Employee added successfully.");
        WebElement employeeListTab = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        employeeListTab.click();
        WebElement employeeNameCell = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Bommireddy Sucharitha']")));
        System.out.println("Employee verified in the list.");
        driver.quit();
    }
}

