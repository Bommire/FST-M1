package Stepdefintion;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstExample extends  Baseclass{
	
	@BeforeAll
	public static void setup() {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	}
    @AfterAll
    public static void tearDown() {
    	 driver.quit();
    }
    	 
    	 @Given("User is on the TS Home Page")
    	 
    	 public void openTSHomepage(){
    		 driver.get("https://v1.training-support.net");
    		 Assertions.assertEquals("Training support",driver.getTitle());
    	 }
    	 
    		 @When("User clicks on the about Us link")
    		 public void clickAboutlink() {
    			 
    		 driver.findElement(By.id("about -link")).click();
    			 
    		 }
    	 
    	@Then("the user is redirected to the page")	 
    	public void verifyaboutpage() { 
    		Assertions.assertEquals("AboutTraining support",driver.getTitle());	
    	}
    	 }
    


