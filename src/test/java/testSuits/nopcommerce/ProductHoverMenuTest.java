package testSuits.nopcommerce;

import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import testSuits.BaseTest;

public class ProductHoverMenuTest extends BaseTest {

	@Test
	public void UserCanSelectSubCategoryFromMainMenu() {
		homePage = new HomePage();
		homePage.selectNotebooksMenu();
		Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("notebooks"));
	}
}
