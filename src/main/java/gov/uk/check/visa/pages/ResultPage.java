package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-!-margin-bottom-6']/h2")
    WebElement resultMessegeLocator;


    public String getResultMessege(){
        CustomListeners.test.log(Status.PASS, "Get text " + resultMessegeLocator);
        Reporter.log("Get text " + resultMessegeLocator.toString());
        return getTextFromElement(resultMessegeLocator);
    }
    public void confirmResultMassage(String expectedMessege){

        Assert.assertTrue(getResultMessege().contains(expectedMessege));

    }

}


