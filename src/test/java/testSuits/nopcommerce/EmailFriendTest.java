package testSuits.nopcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testSuits.BaseTest;

public class EmailFriendTest extends BaseTest
{

	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	EmailPage emailObject ;

	// 2- Search For Product
	@Test(priority=1)
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage();
			detailsObject = searchObject.ProductSearchUsingAutoSuggest("MacB");
			Assert.assertEquals(detailsObject.getProductName(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}

	// 3- Email to Friend
	@Test(priority=2)
	public void RegisteredUserCanSendProductToFriend() {
		emailObject = detailsObject.openSendEmail();
		emailObject.sendEmailToFriend("aaa@tte.com", "Hello my friend , check this product");
		Assert.assertTrue(emailObject.getMessageNotification().contains("Your message has been sent."));
	}

	
}
