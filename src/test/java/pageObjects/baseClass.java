package pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import config.frameworkConfig;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class baseClass {
    public WindowsDriver<WindowsElement> driver;

    @Before
    public void setUp() throws Exception {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("app", frameworkConfig.applicationLocation);
                driver = new WindowsDriver(new URL(frameworkConfig.winappRemoteDriver), capabilities);
                driver.manage().timeouts().implicitlyWait(frameworkConfig.winappDefaultWaitTime, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
