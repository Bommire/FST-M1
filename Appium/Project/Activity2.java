package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

	AndroidDriver driver;
    WebDriverWait wait;
    
	@BeforeClass
	public void setUp() throws MalformedURLException{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();
		
		//server address
		URL serverURL = new URL("http://localhost:4723/");	
		//driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test
	public void A() {
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		driver.findElement(AppiumBy.id("editable_title")).sendKeys("Ram Note");
		driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Hi, This is Ram");
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		String result = driver.findElement(AppiumBy.id("index_note_title")).getText();
		System.out.println(result);
		//Assertion
		Assert.assertEquals(result, "Ram Note");
		
	}
	
	@AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
