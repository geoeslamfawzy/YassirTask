package pages;

import base.UIActions;
import org.openqa.selenium.By;

public class ProductDetailsPage
{
	UIActions ui = new UIActions();
	private final By productNamebreadCrumb= By.cssSelector("strong.current-item");
	private final By emailFriendBtn= By.xpath("//button[normalize-space()='Email a friend']");
	private final By productPricelbl = By.cssSelector("span.price-value-4");
	private final By addToWishlistBtn= By.id("add-to-wishlist-button-4");
	private final By addReviewLink = By.linkText("Add your review");
	private final By addToCompareBtn = By.cssSelector("div[class='compare-products'] button[type='button']");
	private final By addToCartBtn= By.id("add-to-cart-button-4");

	public EmailPage openSendEmail()
	{
		ui.clickOn(emailFriendBtn);
		return new EmailPage();
	}

	public void openAddReviewPage() 
	{
		ui.clickOn(addReviewLink);
	}

	public WishlistPage AddProductToWishlist() throws Exception {
		ui.clickOn(addToWishlistBtn);
		ui.navigateToWishlist();
		return new WishlistPage();
	}

	public ProductDetailsPage AddProductToCompare() {
		ui.clickOn(addToCompareBtn);
		return this;
	}

	public ShoppingCartPage AddToCart() throws Exception {
		ui.clickOn(addToCartBtn);
		ui.navigateToCarts();
		return new ShoppingCartPage();
	}

	public String getProductName(){
		return ui.getTextOfElement(productNamebreadCrumb);
	}

	public String getProductPrice(){
		return ui.getTextOfElement(productPricelbl);
	}

}
