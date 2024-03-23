package testSuits.nopcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import testSuits.BaseTest;

public class MyAccountTest extends BaseTest{
	MyAccountPage myAccountObject ;
	String oldPassword = "1234567" ;
	String newPassword = "123456" ;
	
	
	@Test(priority=1)
	public void RegisteredUserCanChangePassword() {
		myAccountObject = homePage.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.getResultLabel().contains("Password was changed"));
		myAccountObject.closeNotificationMessage();
	}

	@Test(priority=2)
	public void RegisteredUserCanLogout() {
		homePage = myAccountObject.userLogout();
	}
	
	@Test(priority=3)
	public void RegisteredUserCanLogin() 
	{
		homePage.openLoginPage().userLogin(email, newPassword);
		Assert.assertTrue(homePage.getLogoutLink().contains("Log out"));
	}

}
