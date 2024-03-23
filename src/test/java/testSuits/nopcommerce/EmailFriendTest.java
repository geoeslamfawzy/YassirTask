package testSuits.nopcommerce;

import dataProvider.ExcelSheet;
import enums.EnumMapping;
import enums.Messages;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testSuits.BaseTest;

public class EmailFriendTest extends BaseTest {
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	EmailPage emailObject ;

	// 2- Search For Product
	@Test(priority=1, dataProvider = "auto Suggest", dataProviderClass = ExcelSheet.class)
	public void UserCanSearchWithAutoSuggest(String productName, String partialProductName)
	{
		try {
			searchObject = new SearchPage();
			detailsObject = searchObject.ProductSearchUsingAutoSuggest(partialProductName);
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
		Assert.assertTrue(emailObject.getMessageNotification().
				contains(EnumMapping.map(Messages.SentSuccess)));
	}

	
}
