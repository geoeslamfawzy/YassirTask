package testSuits.nopcommerce;

import dataProvider.ExcelSheet;
import enums.EnumMapping;
import enums.Messages;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testSuits.BaseTest;

public class AddProductReviewTest extends BaseTest
{

	/*
	 * 1- User registration
	 * 2- Search for product
	 * 3- Add reivew 
	 * 4- Logout
	 */

	SearchPage searchPage ;
	ProductDetailsPage detailsObject ;
	ProductReviewPage reviewObject ;


	// 1- Search For Product
	@Test(priority=1, dataProvider = "auto Suggest", dataProviderClass = ExcelSheet.class)
	public void UserCanSearchForProductsWithAutoSuggest(String productName, String partialProductName) {
		try {
			searchPage = new SearchPage();
			searchPage.ProductSearchUsingAutoSuggest(partialProductName);
			detailsObject = new ProductDetailsPage();
			Assert.assertEquals(detailsObject.getProductName(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}

	// 3- Add review
	@Test(priority=2)
	public void RegisteredUserCanReviewProduct() {
		detailsObject.openAddReviewPage();
		reviewObject = new ProductReviewPage();
		reviewObject.AddProductReview("new review", "the product is very good");
		Assert.assertTrue(reviewObject.getReviewNotificationMsg()
				.contains(EnumMapping.map(Messages.ReviewNotification)));
	}
}
