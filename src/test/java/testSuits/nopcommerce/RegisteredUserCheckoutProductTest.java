package testSuits.nopcommerce;

import dataProvider.ExcelSheet;
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

	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	ShoppingCartPage cartPage ; 
	CheckoutPage checkoutObject ;
	OrderDetailsPage orderObject ;


	@Test(priority=1, dataProvider = "auto Suggest", dataProviderClass = ExcelSheet.class)
	public void UserCanSearchWithAutoSuggest(String productName, String partialProductName)
	{
		try {
			searchObject = new SearchPage();
			searchObject.ProductSearchUsingAutoSuggest(partialProductName);
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

	@Test(priority=3, dataProvider = "getCheckoutData", dataProviderClass = ExcelSheet.class)
	public void UserCanCheckoutProduct(String countryName, String address, String postcode,
									   String phone, String city, String productName) throws InterruptedException {
		checkoutObject = new CheckoutPage();
		cartPage.openCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct
				(countryName, address, postcode, phone, city, productName);
		Assert.assertTrue(checkoutObject.productName().isDisplayed());
		Assert.assertTrue(checkoutObject.productName().getText().contains(productName));
		Assert.assertTrue(checkoutObject.ThankYoulbl().isDisplayed());
		orderObject = checkoutObject.viewOrderDetails();
		Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("orderdetails"));
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
	}
}
