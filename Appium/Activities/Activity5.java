package Activitys;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void smsTest() {
        driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("recipient_text_view")
        ));
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("9014842678");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
        String messageTextSent = driver.findElement(AppiumBy.id("message_text")).getText();
        Assert.assertEquals(messageTextSent, "Hello from Appium");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
