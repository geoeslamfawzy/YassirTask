package enums;

import java.util.HashMap;
import java.util.Map;

public class EnumMapping {
    public static String map(Enum key) {
        Map<Enum, String> dict = new HashMap<>();
        dict.put(Messages.ReviewNotification, "Product review is successfully added.");
        dict.put(Messages.EmptyCart, "Your Shopping Cart is empty");
        dict.put(Messages.EmptyWishList, "The wishlist is empty!");
        dict.put(Messages.ContactUsSuccess, "Your enquiry has been successfully sent to the store owner.");
        dict.put(Messages.SentSuccess, "Your message has been sent.");
        dict.put(Messages.ChangePasswordSuccess, "Password was changed");

        dict.put(Currency.Euro, "€");
        String value = dict.get(key);
        return value;
    }

}
