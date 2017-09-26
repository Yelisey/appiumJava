package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yelissey on 26.09.2017.
 */
public class DriverInit {

    // Private properties
    private DesiredCapabilities capabilities;
    private String browserName;
    private String baseUrl;
    private WebDriver _driver;

    public DriverInit(String browserName, String baseUrl) {
        setBrowser(browserName);
        setBaseUrl(baseUrl);
        Initialize(getBrowser());
    }
    private void Initialize(String browser) {

        capabilities = new DesiredCapabilities();

        if (browser.equals("Android")){
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "Android");
            capabilities.setCapability(MobileCapabilityType.APP, "Android");
        }
        else if (browser.equals("iOS")){
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.PLATFORM, "iOS");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "iOS");
            capabilities.setCapability(MobileCapabilityType.APP, "iOS");
            capabilities.setCapability(MobileCapabilityType.UDID, "udid");
        }

        try {
            _driver = new AppiumDriver(new URL("http://0.0.0.0:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        _driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    private String getBrowser() {
        return this.browserName;
    }

    private void setBrowser(String browserName) {
        this.browserName = browserName;
    }

    private void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private String getBaseUrl() {
        return this.baseUrl;
    }
}
