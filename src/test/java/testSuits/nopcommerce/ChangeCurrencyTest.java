package testSuits.nopcommerce;

import dataProvider.ExcelSheet;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import testSuits.BaseTest;

public class ChangeCurrencyTest extends BaseTest {
	ProductDetailsPage detailsObject ;
	SearchPage searchObject ;

	@Test(priority=1)
	public void UserCanCanChangeCurrency() {
		homePage.changeCurrency();
	}

	@Test(priority=1, dataProvider = "auto Suggest", dataProviderClass = ExcelSheet.class)
	public void UserCanSearchWithAutoSuggest(String productName, String partialProductName)
	{
		try {
			searchObject = new SearchPage();
			searchObject.ProductSearchUsingAutoSuggest(partialProductName);
			detailsObject = new ProductDetailsPage();
			Assert.assertEquals(detailsObject.getProductName(), productName);
			Assert.assertTrue(detailsObject.getProductPrice().contains("€"));
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}
	
}
