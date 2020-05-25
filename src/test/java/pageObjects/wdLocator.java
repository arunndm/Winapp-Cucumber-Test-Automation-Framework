package pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
;

public class wdLocator {
    private baseClass _baseClass;
    private WindowsDriver driver=null;
    public wdLocator(baseClass _baseClass){
        driver=_baseClass.driver;
    }

    // Sample Locators as examples
    public WebElement signInLabel(){ return driver.findElementByName("Sign in or create");}
    public WebElement rememberMeNo() {return driver.findElementByName("No");}

}
