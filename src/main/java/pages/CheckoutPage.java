package pages;

import base.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage
{
	UIActions ui = new UIActions();
	private final By  guestBtn = By.cssSelector("input.button-1.checkout-as-guest-button");
	private final By  fnTxt = By.id("BillingNewAddress_FirstName");
	private final By  lnTxt = By.id("BillingNewAddress_LastName");
	private final By  emailTxt = By.id("BillingNewAddress_Email");
	private final By countryList = By.id("BillingNewAddress_CountryId");
	private final By phoneTxt = By.id("BillingNewAddress_PhoneNumber");
	private final By cityTxt= By.id("BillingNewAddress_City");
	private final By  addressTxt= By.id("BillingNewAddress_Address1");
	private final By  postCodeTxt= By.id("BillingNewAddress_ZipPostalCode");
	private final By  continueBtn = By.xpath("//button[@id='save-billing-address-button']/following-sibling::button[text()= 'Continue']");
	private final By  shippingMethodRdo = By.xpath("//button[contains(@class,'shipping-method-next-step-button')]");
	private final By  continueShippingBtn = By.xpath("//button[contains(@class, 'payment-method-next-step-button')]");
	private final By  continuePaymentBtn = By.xpath("//button[contains(@class, 'payment-info-next-step-button')]");
	private final By  productName = By.cssSelector("a.product-name");
	private final By  confirmBtn =  By.xpath("//button[contains(@class,  'confirm-order-next-step-button')]");
	private final By continueToHomeBtn = By.xpath("//button[normalize-space()='Continue']");
	private final By  thankYoulbl= By.cssSelector("h1");
	private final By  successMessage = By.cssSelector("div.title");
	private final By  orderDetailsLink= By.linkText("Click here for order details.");

	public void RegisteredUserCheckoutProduct(String countryName, String address,
											  String postcode, String phone, String city, String productName) throws InterruptedException {
		ui.select(countryList, countryName);
		ui.writeIn(cityTxt, city);
		ui.writeIn(addressTxt, address);
		ui.writeIn(postCodeTxt, postcode);
		ui.writeIn(phoneTxt, phone);
		ui.clickOn(continueBtn);
		ui.clickOn(shippingMethodRdo);
		ui.clickOn(continueShippingBtn);
		ui.clickOn(continuePaymentBtn);
		ui.clickOn(confirmBtn);
	}

	public void continueToHomePage() throws InterruptedException
	{
		ui.clickOn(continueToHomeBtn);
	}

	public OrderDetailsPage viewOrderDetails() {
		ui.clickOn(orderDetailsLink);
		return new OrderDetailsPage();
	}


	public void CheckoutProduct(String firstName, String lastName, String countryName,
			String email, String address, String postcode, 
			String phone, String city, String productName) throws InterruptedException {
		ui.writeIn(fnTxt, firstName);
		ui.writeIn(lnTxt, lastName);
		ui.writeIn(emailTxt, email);
		ui.select(countryList, countryName);
		ui.writeIn(cityTxt, city);
		ui.writeIn(addressTxt, address);
		ui.writeIn(postCodeTxt, postcode);
		ui.writeIn(phoneTxt, phone);
		ui.clickOn(continueBtn);
		ui.clickOn(shippingMethodRdo);
		ui.clickOn(continueShippingBtn);
		ui.clickOn(continuePaymentBtn);
		ui.clickOn(confirmBtn);
	}

	public WebElement productName(){
		return ui.findElement(productName);
	}
	public WebElement ThankYoulbl(){
		return ui.findElement(thankYoulbl);
	}

}
