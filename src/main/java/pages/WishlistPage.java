package pages;

import base.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishlistPage
{
    UIActions ui = new UIActions();
    private final By productCell = By.cssSelector("td.product");
    private final By  wishlistHeader = By.cssSelector("h1");
    private final By updateWishlistBtn = By.name("updatecart");
    private final By removeFromCartCheck = By.xpath("//button[@class='remove-btn']");
    private final By  emptyCartLbl = By.cssSelector("div.no-data");

    public void removeProductFromWishlist() {
        ui.clickOn(removeFromCartCheck);
    }

    public WebElement getWishlistHeader(){
        return ui.findElement(wishlistHeader);
    }

    public String getProductCell(){
        return ui.getTextOfElement(productCell);
    }

    public String getEmptyCartLbl(){
        return ui.getTextOfElement(emptyCartLbl);
    }
}
