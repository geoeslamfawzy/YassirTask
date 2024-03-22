package testSuits;

import helpers.JsonHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Try {
    public static void main(String[] args) throws IOException {
        JsonHelper jsonHelper = new JsonHelper("noopCommerceData"); // Replace "data" with your JSON file name
       // HashMap<String, String> registrationData = jsonHelper.getJsonDataToMap("registrationData");
        Object[][] registrationData = jsonHelper.getJsonData("registrationData");

        for (Object[] obj : registrationData) {
            System.out.println(obj);
            System.out.println(obj[0] + ": " + obj[1]);
        }
    }
}