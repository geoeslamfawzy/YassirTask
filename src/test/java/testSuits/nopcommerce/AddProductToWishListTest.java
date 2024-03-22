package testSuits.nopcommerce;

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
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchPage = new SearchPage();
		productDetails = searchPage.ProductSearchUsingAutoSuggest("MacBo");
		Assert.assertTrue(productDetails.getProductName().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToWishlist() throws InterruptedException {
		productDetails.AddProductToWishlist();
		DriverManager.getDriver().navigate().to("http://demo.nopcommerce.com" + "/wishlist");
		wishlistObject = new WishlistPage();
		Assert.assertTrue(wishlistObject.getWishlistHeader().isDisplayed());
		Assert.assertTrue(wishlistObject.getProductCell().contains(productName));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		wishlistObject.removeProductFromWishlist();
		Assert.assertTrue(wishlistObject.getEmptyCartLbl().contains("The wishlist is empty!"));
	}

}
