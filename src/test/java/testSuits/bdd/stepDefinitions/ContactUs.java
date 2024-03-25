package testSuits.bdd.stepDefinitions;

import enums.EnumMapping;
import enums.Messages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import testSuits.BaseTest;

public class ContactUs {
    ContactUsPage contactPage;
    HomePage homePage = BaseTest.homePage;
    @Given("User navigate to contact us page")
    public void userNavigateToContactUsPage() {
        contactPage = homePage.openContactUsPage();
    }

    @When("user has to write {string} , {string}, and {string} in their fields")
    public void userHasToWriteAndInTheirFields(String fullName, String email, String enquiry) {
        contactPage.ContactUs(fullName, email, enquiry);
    }

    @Then("I should validate that user send us his enquiry")
    public void iShouldValidateThatUserSendUsHisEnquiry() {
        Assert.assertTrue(contactPage.getSuccessMessage()
                .contains(EnumMapping.map(Messages.ContactUsSuccess)));
    }
}
