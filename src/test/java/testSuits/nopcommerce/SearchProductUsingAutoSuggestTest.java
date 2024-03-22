package testSuits.nopcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import testSuits.BaseTest;

public class SearchProductUsingAutoSuggestTest extends BaseTest{
	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	
	@Test
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchObject = new SearchPage();
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage();
			Assert.assertEquals(detailsObject.getProductName(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}
}
