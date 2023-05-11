package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'longer than 6 months')]")
    WebElement  moreThanSixMonths;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'6 months or less')]")
    WebElement  lessThanSixMonths;
    @CacheLookup
    @FindBy(xpath = "(//button[@type='submit'])[4]")
    WebElement nextBtn;

    public void clickOnNext(){
        clickOnElement(nextBtn);
        Reporter.log("click on continue" + nextBtn.toString());
        CustomListeners.test.log(Status.PASS,"click on continue");

    }


    public  void selectLengthOfStay(String moreOrLess){
        switch (moreOrLess){
            case "6 months or less":
                clickOnElement(lessThanSixMonths);
                break;
            case "longer than 6 months":
                clickOnElement(moreThanSixMonths);
                break;
            default:

        }

    }
}
