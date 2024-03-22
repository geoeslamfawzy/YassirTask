package pages;

import base.UIActions;
import org.openqa.selenium.By;

public class ProductReviewPage
{

	UIActions ui = new UIActions();
	private final By reviewTitleTxt = By.id("AddProductReview_Title");

	private final By reviewText = By.id("AddProductReview_ReviewText");
	private final By rating4RdoBtn= By.id("addproductrating_4");
	private final By submitReviewBtn= By.name("add-review");
	private final By reviewNotification= By.cssSelector("div.result");

	public void AddProductReview(String reviewTitle, String reviewMessage) {
		ui.writeIn(reviewTitleTxt, reviewTitle);
		ui.writeIn(reviewText, reviewMessage);
		ui.clickOn(rating4RdoBtn);
		ui.clickOn(submitReviewBtn);
	}
	public String getReviewNotificationMsg(){
		return ui.getTextOfElement(reviewNotification);
	}


}
