package testSuits.nopcommerce;

import dataProvider.ExcelSheet;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import testSuits.BaseTest;

public class SearchProductUsingAutoSuggestTest extends BaseTest{
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	
	@Test(dataProviderClass = ExcelSheet.class, dataProvider = "auto Suggest")
	public void UserCanSearchWithAutoSuggest(String productName, String partialNameOfProduct)
	{
		try {
			searchObject = new SearchPage();
			searchObject.ProductSearchUsingAutoSuggest(partialNameOfProduct);
			detailsObject = new ProductDetailsPage();
			Assert.assertEquals(detailsObject.getProductName(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}
}
