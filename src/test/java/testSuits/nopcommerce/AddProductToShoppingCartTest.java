package testSuits.nopcommerce;

import dataProvider.ExcelSheet;
import enums.EnumMapping;
import enums.Messages;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import testSuits.BaseTest;

public class AddProductToShoppingCartTest extends BaseTest {
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartPage ;
	@Test(priority=1, dataProvider = "auto Suggest", dataProviderClass = ExcelSheet.class)
	public void UserCanSearchForProductsWithAutoSuggest(String productName, String partialProductName) throws InterruptedException {
		searchPage = new SearchPage();
		productDetails = searchPage.ProductSearchUsingAutoSuggest(partialProductName);
		Assert.assertTrue(productDetails.getProductName().contains(productName));
	}
	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws Exception {
		cartPage = productDetails.AddToCart();
		Assert.assertTrue(cartPage.getTotalLabel().contains("3,600"));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		cartPage.RemoveProductFromCart();
		Assert.assertTrue(cartPage.getEmptyCartMessage().contains(EnumMapping.map(Messages.EmptyCart)));
	}
}
