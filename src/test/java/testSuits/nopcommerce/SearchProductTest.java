package testSuits.nopcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import testSuits.BaseTest;

public class SearchProductTest extends BaseTest{
	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	
	@Test
	public void UserCanSearchForProducts() 
	{
		searchObject  = new SearchPage();
		detailsObject = new ProductDetailsPage();
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
		Assert.assertEquals(detailsObject.getProductName(), productName);
	}

}
