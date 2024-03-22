package testSuits.nopcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import testSuits.BaseTest;

public class ChangeCurrencyTest extends BaseTest
{
	ProductDetailsPage detailsObject ;
	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObject ;

	@Test(priority=1)
	public void UserCanCanChangeCurrency() {
		homePage.changeCurrency();
	}
	
	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchObject = new SearchPage();
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage();
			Assert.assertEquals(detailsObject.getProductName(), productName);
			Assert.assertTrue(detailsObject.getProductPrice().contains("€"));
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}
	
	
}
