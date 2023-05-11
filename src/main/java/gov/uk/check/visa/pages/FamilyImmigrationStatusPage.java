package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class FamilyImmigrationStatusPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(id = "response-0")
    WebElement yes;
    @CacheLookup
    @FindBy(id = "response-1")
    WebElement no;
    public void selectImmigrationStatus(String status){
        switch(status){
            case "Yes" :
                clickOnElement(yes);
                break;
            case "No":
                clickOnElement(no);
                break;
            default:
                System.out.println("Wrong status");
        }


    }
    public void clickNextStepButton(){
        Reporter.log("click on continue" + nextStepButton.toString());
        mouseHoverToElementAndClick(nextStepButton);
        CustomListeners.test.log(Status.PASS,"click on continue");


    }


}
