package pages;

import base.UIActions;
import org.openqa.selenium.By;

public class ContactUsPage
{
    UIActions ui = new UIActions();
    private final By fullNameTxt = By.id("FullName");
    private final By emailTxt = By.id("Email");
    private final By enquiryTxt = By.id("Enquiry");

    private final By submitBtn = By.name("send-email");

    private final By successMessage = By.cssSelector("div.result");

    public void ContactUs(String fullName , String email , String message) 
    {
    	 ui.writeIn(fullNameTxt, fullName);
         ui.writeIn(emailTxt, email);
         ui.writeIn(enquiryTxt, message);
         ui.clickOn(submitBtn);
    }

    public String getSuccessMessage(){
        return ui.getTextOfElement(successMessage);
    }
}
