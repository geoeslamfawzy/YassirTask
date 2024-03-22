package pages;

import base.UIActions;
import org.openqa.selenium.By;

import java.util.Random;

public class RegistrationPage
{
	UIActions ui = new UIActions();
	private final By genderRdoBtn = By.id("gender-male");
	private final By  fnTxtBox = By.id("FirstName");
	private final By lnTxtBox = By.id("LastName");
	private final By emailTxtBox = By.id("Email");
	private final By passwordTxtBox = By.id("Password");
	private final By confirmPasswordTxtBox = By.id("ConfirmPassword");
	private final By registerBtn = By.id("register-button");
	private final By successMessage = By.cssSelector("div.result");
	private final By continueBtn = By.xpath("//a[text()='Continue']");
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private final By loginLink = By.linkText("//a[@class='ico-login']");



	public HomePage userRegistration(String firstName , String lastName , String email , String password)
	{
		ui.clickOn(genderRdoBtn);
		ui.writeIn(fnTxtBox, firstName);
		ui.writeIn(lnTxtBox, lastName);
		ui.writeIn(emailTxtBox, email);
		ui.writeIn(passwordTxtBox, password);
		ui.writeIn(confirmPasswordTxtBox, password);
		ui.clickOn(registerBtn);
		System.out.println(email);
		return new HomePage();
	}

	public HomePage userLogout()
	{
		ui.clickOn(logoutLink);
		return new HomePage();
	}


	private final By logoutLink = By.linkText("Log out");

	public String getSuccessMsg(){
		return ui.getTextOfElement(successMessage);
	}
	public String getLogoutLink(){
		return ui.getTextOfElement(logoutLink);
	}

	public String generateRandomEmail() {
		StringBuilder email = new StringBuilder();
		Random random = new Random();

		// Generate random username
		int usernameLength = random.nextInt(10) + 5; // Random length between 5 and 14
		for (int i = 0; i < usernameLength; i++) {
			email.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
		}

		// Add '@' symbol
		email.append("@");

		// Generate random domain name
		int domainLength = random.nextInt(10) + 5; // Random length between 5 and 14
		for (int i = 0; i < domainLength; i++) {
			email.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
		}

		// Add '.' and top-level domain (e.g., '.com', '.org', etc.)
		email.append(".");
		String[] topLevelDomains = {"com", "org", "net", "edu", "gov"};
		email.append(topLevelDomains[random.nextInt(topLevelDomains.length)]);

		return email.toString();
	}
	public HomePage navigateToHome(){
		ui.clickOn(continueBtn);
		return new HomePage();
	}
	public LoginPage navigateToLoginPage(){
		ui.clickOn(loginLink);
		return new LoginPage();
	}


}
