package pages;

import base.UIActions;
import constants.FrameworkConstants;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage
{
    UIActions ui = new UIActions();
    private final By  changePasswordLink= By.linkText("Change password");

    private final By  oldPasswordTxt = By.id("OldPassword");
    private final By  newPasswordTxt = By.id("NewPassword");
    private final By confirmPasswordTxt = By.id("ConfirmNewPassword");
    private final By  ChangePasswordBtn= By.xpath("//button[normalize-space()='Change password']");
    private final By  resultLbl = By.cssSelector(".content");
    private final By closeMsg = By.cssSelector("span[title='Close']");
    private final By logoutLink = By.linkText("Log out");

    public MyAccountPage openChangePasswordPage()
	{
		ui.clickOn(changePasswordLink);
        return this;
	}
	public MyAccountPage changePassword(String oldpassword, String newpassword) {
        ui.writeIn(oldPasswordTxt, oldpassword);
        ui.writeIn(newPasswordTxt, newpassword);
        ui.writeIn(confirmPasswordTxt, newpassword);
        ui.clickOn(ChangePasswordBtn);
        return this;
    }

    public String getResultLabel(){
        return ui.getTextOfElement(resultLbl);
    }
    public MyAccountPage closeNotificationMessage() {
        ui.clickOn(closeMsg);
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.invisibilityOfElementLocated(closeMsg));
        ui.scrollToBottom();
        return this;
    }

    public HomePage userLogout()
    {
        ui.scrollUp();
        ui.clickOn(logoutLink);
        return new HomePage();
    }
}
