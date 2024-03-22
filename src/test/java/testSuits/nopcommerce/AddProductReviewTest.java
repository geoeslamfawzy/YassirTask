package testSuits.nopcommerce;

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

	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchPage ;
	ProductDetailsPage detailsObject ;
	ProductReviewPage reviewObject ;


	// 1- Search For Product
	@Test(priority=1)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchPage = new SearchPage();
			searchPage.ProductSearchUsingAutoSuggest("MacB");
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
		reviewObject.AddProductReview("new reivew", "the product is very good");
		Assert.assertTrue(reviewObject.getReviewNotificationMsg()
				.contains("Product review is successfully added."));
	}
}
