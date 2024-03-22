package testSuits.nopcommerce;

import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testSuits.BaseTest;

public class RegisteredUserCheckoutProductTest extends BaseTest{
	/*
	 * 1- Register User
	 * 2- Search for product
	 * 3- Add to Cart
	 * 4- Checkout
	 * 5- Logout 
	 */

	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	ShoppingCartPage cartPage ; 
	CheckoutPage checkoutObject ;
	OrderDetailsPage orderObject ;


	@Test(priority=1)
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

	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		detailsObject = new ProductDetailsPage();
		detailsObject.AddToCart();
		Thread.sleep(1000);
		DriverManager.getDriver().navigate().to("http://demo.nopcommerce.com" + "/cart");
		cartPage = new ShoppingCartPage();
		Assert.assertTrue(cartPage.getTotalLabel().contains("3,600"));
	}

	@Test(priority=3)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new CheckoutPage();
		cartPage.openCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct
		("Egypt", "test address", "123456", "32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.productName().isDisplayed());
		Assert.assertTrue(checkoutObject.productName().getText().contains(productName));
		Assert.assertTrue(checkoutObject.ThankYoulbl().isDisplayed());
		orderObject = checkoutObject.viewOrderDetails();
		Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("orderdetails"));
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
	}
}
