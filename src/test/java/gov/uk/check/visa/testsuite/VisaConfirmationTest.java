package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
@Test(groups = {"smoke","sanity","regeression"})
public class VisaConfirmationTest extends BaseTest {
    DurationOfStayPage durationOfStayPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    SelectNationalityPage selectNationalityPage;
    StartPage startPage;
    WorkTypePage workTypePage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        durationOfStayPage = new DurationOfStayPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
       reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        selectNationalityPage = new SelectNationalityPage();
        startPage = new StartPage();
        workTypePage = new WorkTypePage();
    }
    @Test(groups = {"regeression"})
    public void anAustralianCominToUKForTourism(){
        //Accept cookies
        startPage.acceptCookies();
        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Australia'
        selectNationalityPage.selectNationality("Australia");
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");
        //Click on Continue button
        reasonForTravelPage.clickOnNextStep();
        //verify result 'You will not need a visa to come to the UK'
        resultPage.confirmResultMassage("You will not need a visa to come to the UK");


    }
    @Test(groups = {"sanity","regeression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() throws InterruptedException {
        //Search again
        //resultPage.backToHomepage();
        //Accept cookies
        startPage.acceptCookies();
        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Australia'
        selectNationalityPage.selectNationality("Chile");
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        Thread.sleep(2000);
        //Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        //Click on Continue button
        reasonForTravelPage.clickOnNextStep();
        //Select intendent to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
       // Click on Continue button
       durationOfStayPage.clickOnNext();
        //Select have planning to work for 'Health and care professional'
        workTypePage.selectJobType("Health and care professional");
        //Click on Continue button
        workTypePage.clickContinueButton();
        // verify result 'You need a visa to work in health and care'
        resultPage.confirmResultMassage("You need a visa to work in health and care");


    }
    @Test
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){
        //Accept cookies
        startPage.acceptCookies();
        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Columbia'
        selectNationalityPage.selectNationality("Colombia");
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //Select reason Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
       // Click on Continue button
       durationOfStayPage.clickOnNext();
        // Select state My partner of family member have uk immigration status 'yes'
        //familyImmigrationStatusPage.selectImmigrationStatus("yes");
        // Click on Continue button
        //workTypePage.clickContinueButton();
        //verify result 'You’ll need a visa to join your family or partner in the UK'
        resultPage.confirmResultMassage("You may need a visa");

    }

}
