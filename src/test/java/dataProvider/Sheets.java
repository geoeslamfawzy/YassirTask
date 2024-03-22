package dataProvider;

import helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

import java.io.IOException;


public class Sheets {
    @DataProvider(name = "loginWithValidCredentials")
    public Object[][] loginWithValidCredentials() throws IOException {
        ExcelHelper xl = new ExcelHelper("loginData");
        return xl.getDataFromExcel("CorrectCredentials");
    }

    @DataProvider(name = "employeeData")
    public Object[][] addEmployeeData() throws IOException {
        ExcelHelper xl = new ExcelHelper("Add Employee");
        return xl.getDataFromExcel("employeeData");
    }

    @DataProvider(name="registrationData", parallel = true)
    public Object[][] registerInNopcommerce() throws IOException {
        ExcelHelper xl = new ExcelHelper("registrationData");
        return xl.getDataFromExcel("Sheet1");
    }
   /* @DataProvider(name="getPassword", parallel = true)
    public Object[][] getPasswordOfRegisteredMail() throws IOException {
        ExcelHelper xl = new ExcelHelper("registrationData");
        return xl.getDataFromColumn("registrationData", "password");
    }*/

    @DataProvider(name="registerData", parallel = true)
    public Object[][] register() throws IOException {
        ExcelHelper xl = new ExcelHelper("noopCommerceData");
        return xl.getDataFromExcel("registration");
    }

}
