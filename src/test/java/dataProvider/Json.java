package dataProvider;

import helpers.JsonHelper;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class Json {
//    @DataProvider(name = "loginData_happyScenario")
//    public Object[][] getData() throws IOException {
//        JsonHelper jsonHelper = new JsonHelper("loginData");
//        return jsonHelper.getJsonData("userLogins");
//    }

    @DataProvider(name = "registration")
    public Object[][] getDataFromJson_noopCommerce() throws IOException {
        JsonHelper jsonHelper = new JsonHelper("noopCommerceData"); // Replace "data" with your JSON file name
       return jsonHelper.getJsonData("registrationData");
    }




}
