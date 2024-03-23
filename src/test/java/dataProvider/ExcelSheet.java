package dataProvider;
import helpers.ExcelHelper;
import org.testng.annotations.DataProvider;
import java.io.IOException;


public class ExcelSheet {
    private String fileName;
    public ExcelSheet(){
    }
    public ExcelSheet(String fileName){
        this.fileName = fileName;
    }
    @DataProvider(name = "getCheckoutData")
    public Object[][] getCheckoutData() throws IOException {
        ExcelHelper xl = new ExcelHelper("noopCommerceData");
        return xl.getDataFromExcel("product checkout");
    }
    @DataProvider(name = "auto Suggest")
    public Object[][] getAutoSuggestData() throws IOException {
        ExcelHelper xl = new ExcelHelper("noopCommerceData");
        return xl.getDataFromExcel("auto Suggest");
    }

    @DataProvider(name = "product name")
    public Object[][] getProductName() throws IOException {
        ExcelHelper xl = new ExcelHelper("noopCommerceData");
        return xl.getColumnData("auto Suggest", "productName");
    }




}
