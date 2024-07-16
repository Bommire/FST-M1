package Activitys;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/lazy-loading");
    }
    @Test
    public void chromeTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));
        List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Before scroll: " + imageElements.size());
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"helen\")"));
        imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("After scroll: " + imageElements.size());
        Assert.assertEquals(imageElements.size(), 5);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
