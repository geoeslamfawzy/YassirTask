package testSuits;

import driver.DriverActions;
import driver.DriverManager;
import helpers.ScreenshotHelper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class BaseTest {
    protected BaseTest(){}
    protected HomePage homePage;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected static String email ;
    protected String firstName = "Eslam" ;
    protected  String lastName = "Fawzy" ;
    protected String password = "1234567";
    @BeforeClass
    protected void setUp() throws Exception {
        DriverActions.initDriver();
        homePage = new HomePage();
        registrationPage = homePage.openRegistrationPage();
        email = registrationPage.generateRandomEmail();
        registrationPage.userRegistration(firstName, lastName, email, password);
        Assert.assertTrue(registrationPage.getSuccessMsg().contains("Your registration completed"));
        loginPage = registrationPage.navigateToHome().openLoginPage();
        homePage = loginPage.userLogin(email, password);
        Assert.assertTrue(registrationPage.getLogoutLink().contains("Log out"));
    }
    @AfterClass
    protected void tearDown(){
        registrationPage.userLogout();
        DriverActions.quitDriver();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            ScreenshotHelper.captureScreenshot(DriverManager.getDriver(), result.getName());
        }
    }
}

