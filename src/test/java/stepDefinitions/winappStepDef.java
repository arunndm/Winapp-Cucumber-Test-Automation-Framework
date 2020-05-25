package stepDefinitions;

import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import pageObjects.baseClass;
import helper.helper;
import pageObjects.*;

public class winappStepDef {
    private baseClass _baseClass;
    private wdLocator objwdLocator;
    public static WindowsDriver driver=null;
    private helper objhelper = null;
    public winappStepDef(baseClass _baseClass) throws Exception {
        _baseClass.setUp();
        driver=_baseClass.driver;
        objwdLocator=new wdLocator(_baseClass);
        objhelper=new helper(_baseClass);
    }
    @When("I click {string} button")
    public void iClickButton(String buttonName) {
        objhelper.getElementFromJsonPo(buttonName).click();
    }

    @And("I provide {string} in textbox {string}")
    public void iProvideInTextbox(String text, String textbox) {
        WebElement element = objhelper.getElementFromJsonPo(textbox);
        element.click();
        element.sendKeys(text);
    }

    @Then("I see {string}")
    public void iSee(String element) { Assert.assertTrue(objhelper.getElementFromJsonPo(element).isDisplayed()); }
}
