package testSuits.nopcommerce;

import dataProvider.ExcelSheet;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import testSuits.BaseTest;

public class SearchProductTest extends BaseTest{
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	
	@Test(dataProviderClass = ExcelSheet.class, dataProvider = "product name")
	public void UserCanSearchForProducts(String productName)
	{
		searchObject  = new SearchPage();
		detailsObject = new ProductDetailsPage();
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
		Assert.assertEquals(detailsObject.getProductName(), productName);
	}
}
