package pages;

import base.UIActions;
import org.openqa.selenium.By;

public class ShoppingCartPage
{

	UIActions ui = new UIActions();
	private final By removeCheck = By.xpath("//button[@class='remove-btn']");
	private final By  updateCartBtn = By.id("updatecart");
	private final By quantityTxt = By.cssSelector("input.qty-input valid");

	private final By totalLbl = By.cssSelector("td.subtotal");
	private final By checkoutBtn = By.id("checkout");
	private final By agreeCheckbox = By.id("termsofservice");
	private final By guestCheckoutBtn = By.cssSelector("input.button-1.checkout-as-guest-button");
	private final By emptyCartMsg = By.xpath("//div[@class='no-data']");
	public void RemoveProductFromCart() {
		ui.clickOn(removeCheck);
	}

	public void UpdateProductQuantityInCart(String quantity) {
		ui.writeIn(quantityTxt, quantity);
		ui.clickOn(updateCartBtn);
	}

	public CheckoutPage openCheckoutPage()
	{
		ui.clickOn(agreeCheckbox);
		ui.clickOn(checkoutBtn);
		return new CheckoutPage();
	}
	
	public void openCheckoutPageAsGuest() 
	{
		ui.clickOn(agreeCheckbox);
		ui.clickOn(checkoutBtn);
		ui.clickOn(guestCheckoutBtn);
	}

	public String getTotalLabel(){
		return ui.getTextOfElement(totalLbl);
	}
	public String getEmptyCartMessage(){
		return ui.getTextOfElement(emptyCartMsg);
	}

}

