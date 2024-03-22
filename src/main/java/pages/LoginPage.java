package pages;

import base.UIActions;
import org.openqa.selenium.By;

public class LoginPage
{
	UIActions ui = new UIActions();
	private final By emailTxtBox = By.id("Email");
	private final By passwordTxtBox = By.id("Password");
	private final By loginBtn = By.cssSelector("button[class='button-1 login-button']");
	private final By loginLink = By.xpath("//a[@class='ico-login']");
	public HomePage userLogin(String email , String password)
	{
		ui.clickOn(loginLink);
		ui.writeIn(emailTxtBox, email);
		ui.writeIn(passwordTxtBox, password);
		ui.clickOn(loginBtn);
		return new HomePage();
	}

}
