package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	AndroidDriver driver;
    WebDriverWait wait;
    
	@BeforeClass
	public void setUp() throws MalformedURLException{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
		options.noReset();
		
		//server address
		URL serverURL = new URL("http://localhost:4723/");	
		//driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test(priority = 1)
	public void A() {
		//Add new task
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();			
			 //Send the text 
		driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google task");
		driver.findElement(AppiumBy.id("add_task_done")).click(); 
        String result = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name' and @text='Complete Activity with Google task']")).getText();
        System.out.println(result);
		
		//Assertion
		Assert.assertEquals(result, "Complete Activity with Google task");	
		
	}
	@Test(priority = 2)
	public void B() {
		//Add new task
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();			
			 //Send the text 
		driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google keep");
		driver.findElement(AppiumBy.id("add_task_done")).click(); 
		String result = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name' and @text='Complete Activity with Google keep']")).getText();
        System.out.println(result);
		
		//Assertion
		Assert.assertEquals(result, "Complete Activity with Google keep");	
	}
	
	@Test(priority = 3)
	public void C() {
		//Add new task
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();			
			 //Send the text 
		driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
		driver.findElement(AppiumBy.id("add_task_done")).click(); 
		String result = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name' and @text='Complete the second Activity Google Keep']")).getText();
        System.out.println(result);
		
		//Assertion
		Assert.assertEquals(result, "Complete the second Activity Google Keep");
	}
	
	
	 @AfterClass
	    public void tearDown() {
	        // Close the app
	        driver.quit();
	    }

}
