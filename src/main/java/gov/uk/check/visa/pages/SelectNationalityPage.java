package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='response']")
    WebElement nationalityDropDownList;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    public void selectNationality(String nationality){
        selectByVisibleTextFromDropDown(nationalityDropDownList,nationality);
        Reporter.log("Select nationality " + nationalityDropDownList.toString());
        CustomListeners.test.log(Status.PASS, "Nationality" + nationality);
    }
    public void clickNextStepButton(){
        mouseHoverToElementAndClick(nextStepButton);
        Reporter.log("Click on  " + nextStepButton.toString());
        CustomListeners.test.log(Status.PASS, "Job title" + nextStepButton);
    }
}
