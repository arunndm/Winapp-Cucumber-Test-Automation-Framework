package helper;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.baseClass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.json.simple.*;
import org.json.simple.parser.*;

public class helper {
    private baseClass _baseClass;
    private WindowsDriver driver=null;
    public helper(baseClass _baseClass){
        driver=_baseClass.driver;
    }

    public String projectDirectory = System.getProperty("user.dir");
    public static String propPoPath = "\\src\\test\\java\\pageObjects\\propLocator"; //location of property file holding page objects
    static String jsonPoPath = "\\src\\test\\java\\pageObjects\\jsonLocator.json"; //location of json file holding page objects
    public enum locators {xpath,name} // enum to use in the below functions

    // Function to get a element from the property page object file.
    // Returns the element as Webelement
    // Argument(s) : name of the element as string
    public WebElement getElementFromPropertyPo(String elementName) {

        String strElementPath = this.getPropertyValue(elementName);
        WebElement element = null;
        By byElementPath = null;
        String elementLocatorType = null;
        String elementLocatorName = null;

        elementLocatorType = strElementPath.split(";")[0].toString();
        elementLocatorName = strElementPath.split(";")[1].toString();

        switch (locators.valueOf(elementLocatorType))
        {
            case xpath:
                byElementPath = By.xpath(elementLocatorName);
                break;
            case name:
                byElementPath = By.name(elementLocatorName);
                break;
        }
        element = driver.findElement(byElementPath);
        return element;
    }

    // Helper class to get the locator path from property file.
    // Returns the locator details from property file.
    // Argument(s) : Location of  name of the element as string
    public String getPropertyValue(String elementName) {
        Properties prop = new Properties();

        String locatorMainPath = projectDirectory + propPoPath;
        try {
            prop.load(new FileInputStream(locatorMainPath));
        } catch (Exception e) {
            e.printStackTrace(); }
        String elementPath = prop.getProperty(elementName);
        return elementPath;
    }

    // Function to get a element from the JSON page object file.
    // Returns the element as Webelement
    // Argument(s) : name of the element as string
    public WebElement getElementFromJsonPo(String elementName) {
        JSONParser parser = new JSONParser();
        WebElement element = null;
        By byElementPath = null;
        try {
            String JsonMainPath = projectDirectory + jsonPoPath;
            Object obj = parser.parse(new FileReader(JsonMainPath));
            JSONObject jObj = (JSONObject) obj;
            JSONObject objElementLocatorType = (JSONObject) jObj.get(elementName);
            String elementLocatorType = (String) objElementLocatorType.get("findBy");
            String elementLocatorName = (String) objElementLocatorType.get("data");

            switch (locators.valueOf(elementLocatorType)) {
                case xpath:
                    byElementPath = By.xpath(elementLocatorName);
                    break;
                case name:
                    byElementPath = By.name(elementLocatorName);
                    break;
            }
            element = driver.findElement(byElementPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return element;
    }
}
