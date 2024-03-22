package testSuits.nopcommerce;

import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import testSuits.BaseTest;

public class AddProductToShoppingCartTest extends BaseTest
{
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartPage ;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchPage = new SearchPage();
		productDetails = searchPage.ProductSearchUsingAutoSuggest("MacB");
		Assert.assertTrue(productDetails.getProductName().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		productDetails.AddToCart();
		DriverManager.getDriver().navigate().to("http://demo.nopcommerce.com" + "/cart");
		cartPage = new ShoppingCartPage();
		Assert.assertTrue(cartPage.getTotalLabel().contains("3,600"));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		cartPage.RemoveProductFromCart();
		Assert.assertTrue(cartPage.getEmptyCartMessage().contains("Your Shopping Cart is empty"));
	}
}
