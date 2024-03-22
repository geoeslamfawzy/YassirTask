package testSuits.nopcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import testSuits.BaseTest;

public class ContactUsTest extends BaseTest
{
	ContactUsPage contactPage;

	String email = "test@test.com";
	String fullName = "Test User";
	String enquiry = "Hello Admin , this is for test";

	@Test
	public void UserCanUseContactUs() {
		contactPage = homePage.openContactUsPage();
		contactPage.ContactUs(fullName, email, enquiry);
		 Assert.assertTrue(contactPage.getSuccessMessage()
				 .contains("Your enquiry has been successfully sent to the store owner."));
	}

}
