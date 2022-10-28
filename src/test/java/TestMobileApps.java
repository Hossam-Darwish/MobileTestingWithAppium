import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestMobileApps {

    private static AndroidDriver<MobileElement> driver;
    private static WebDriverWait wait;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");  // Paltform IOS , Android
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Tab S6");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        caps.setCapability("autoAcceptAlerts", true);
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("appium:unlockType", "pin");
        caps.setCapability("appium:unlockKey", "1234");
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", ".Calculator");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 100);
    }

    @Test
    public void testAddition() {
        driver.findElementByAccessibilityId("9").click();
        driver.findElementByAccessibilityId("Plus").click();
        driver.findElementByAccessibilityId("5").click();
        driver.findElementByAccessibilityId("Equal").click();

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
