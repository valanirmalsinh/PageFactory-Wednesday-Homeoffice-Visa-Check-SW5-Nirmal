package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[@data-accept-cookies='true']")
    WebElement acceptCookies;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='wrapper']/div[1]/main[1]/div[2]/div[1]/article[1]/section[1]/a[1]")
    WebElement startNowButton;


    public void acceptCookies(){
        mouseHoverToElementAndClick(acceptCookies);
        Reporter.log("Click on" + acceptCookies.toString());
        CustomListeners.test.log(Status.PASS, "Job title" + acceptCookies);
    }
    public void clickStartNow(){
        mouseHoverToElementAndClick(startNowButton);
        Reporter.log("Click on" + startNowButton.toString());
        CustomListeners.test.log(Status.PASS, "Job title" + startNowButton);
    }
}
