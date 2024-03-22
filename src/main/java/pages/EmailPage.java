package pages;

import base.UIActions;
import org.openqa.selenium.By;

public class EmailPage {
    UIActions ui = new UIActions();
    private final By emailFriendTxt = By.id("FriendEmail");
    private final By personalMessageTxt = By.id("PersonalMessage");
    private final By  sendEmailBtn= By.name("send-email");
    private final By  messageNotification= By.cssSelector("div.result");

    public void sendEmailToFriend(String friendEmail, String personalMessage) {
        ui.writeIn(emailFriendTxt, friendEmail);
        ui.writeIn(personalMessageTxt, personalMessage);
        ui.clickOn(sendEmailBtn);
    }

    public String getMessageNotification(){
        return ui.getTextOfElement(messageNotification);
    }
}
