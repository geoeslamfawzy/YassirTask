package pages;

import base.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage
{
	UIActions ui = new UIActions();
	private final By searchTextBox = By.id("small-searchterms");
	private final By searchBtn = By.xpath("//button[normalize-space()='Search']");
	private final By  ProductList = By.id("ui-id-1");
	private final By productTitle= By.linkText("Apple MacBook Pro 13-inch");

	public void ProductSearch(String productName) 
	{
		ui.writeIn(searchTextBox, productName);
		ui.clickOn(searchBtn);
	}

	public void OpenProductDetailsPage() 
	{
		ui.clickOn(productTitle);
	}

	public ProductDetailsPage ProductSearchUsingAutoSuggest(String searchTxt) throws InterruptedException {
		ui.typeTextWithDelay(searchTextBox, searchTxt);
		List<WebElement> ProductList = ui.findElements(this.ProductList);
		ProductList.get(0).click();
		return new ProductDetailsPage();
	}

}
