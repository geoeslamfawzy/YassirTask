package testSuits.nopcommerce;

import dataProvider.ExcelSheet;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;
import testSuits.BaseTest;

public class AddProductToWishListTest extends BaseTest
{
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	WishlistPage wishlistObject;

	@Test(priority=1, dataProvider = "auto Suggest", dataProviderClass = ExcelSheet.class)
	public void UserCanSearchWithAutoSuggest(String productName, String partialProductName) throws InterruptedException {
		searchPage = new SearchPage();
		productDetails = searchPage.ProductSearchUsingAutoSuggest(partialProductName);
		Assert.assertTrue(productDetails.getProductName().contains(productName));
	}

	@Test(priority=2,dataProvider = "product name", dataProviderClass = ExcelSheet.class)
	public void UserCanAddProductToWishlist(String productName) throws Exception {
		wishlistObject = productDetails.AddProductToWishlist();
		Assert.assertTrue(wishlistObject.getWishlistHeader().isDisplayed());
		Assert.assertTrue(wishlistObject.getProductCell().contains(productName));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		wishlistObject.removeProductFromWishlist();
		Assert.assertTrue(wishlistObject.getEmptyCartLbl().contains("The wishlist is empty!"));
	}

}
