package pages;

import base.UIActions;
import org.openqa.selenium.By;

public class HomePage {
    UIActions ui = new UIActions();
    private final By registerLink = By.linkText("Register");
    private final By loginLink = By.linkText("Log in");
    private final By contactUsLink = By.linkText("Contact us");
    private final By currencydrl = By.id("customerCurrency");
    private final By ComputerMenu = By.linkText("Computers");
    private final By NotbooksMenu = By.linkText("Notebooks");
    private final By myAccountLink = By.linkText("My account");
    private final By logoutLink = By.linkText("Log out");


    public RegistrationPage openRegistrationPage()
    {
        ui.clickOn(registerLink);
        return new RegistrationPage();
    }

    public LoginPage openLoginPage()
    {
        ui.clickOn(loginLink);
        return new LoginPage();
    }

    public ContactUsPage openContactUsPage() {
        ui.scrollToBottom();
        ui.clickOn(contactUsLink);
        return new ContactUsPage();
    }

    public void changeCurrency(String currency)
    {
        ui.select(currencydrl, "Euro");
    }

    public void changeCurrency()
    {
        ui.select(currencydrl, "Euro");
    }

    public void selectNotebooksMenu()
    {
        ui.scrollToElement(ComputerMenu);
        ui.scrollToElement(NotbooksMenu);
        ui.clickOn(NotbooksMenu);
    }
    public MyAccountPage openMyAccountPage()
    {
        ui.clickOn(myAccountLink);
        return new MyAccountPage();
    }

    public HomePage logout(){
        ui.clickOn(logoutLink);
        return this;
    }
    public String getLogoutLink(){
        return ui.getTextOfElement(logoutLink);
    }

}
