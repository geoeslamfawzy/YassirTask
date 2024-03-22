package helpers;

import constants.FrameworkConstants;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelHelper {
    static String fileName;
    public ExcelHelper(String fileName)
    {
        this.fileName=fileName + ".xlsx";
    }
    public FileInputStream openExcelFile() throws IOException{
        return  new FileInputStream(FrameworkConstants.readDataFile(this.fileName));
    }

    private XSSFWorkbook openExcelWorkBook() throws IOException {
        return new XSSFWorkbook(openExcelFile());
    }

    public void closeFile() throws IOException {
        openExcelFile().close();
        openExcelWorkBook().close();
    }
    private  XSSFSheet accessSheetInExcel(String sheetName) throws IOException {
        return openExcelWorkBook().getSheet(sheetName);
    }
    public XSSFRow getRow(String sheetName, int rowNum) throws IOException {
        return accessSheetInExcel(sheetName).getRow(rowNum);
    }

    public int getRowCount(String sheetName) throws IOException //how many rows in excell sheet
    {
        int rowCount=accessSheetInExcel(sheetName).getLastRowNum();
        //closeFile();
        return rowCount;
    }
    public int getCellCount(String sheetName,int rowNum) throws IOException //count the number of cells in this row
    {
        int cellCount=getRow(sheetName, rowNum).getLastCellNum();
        //closeFile();
        return cellCount;
    }

    public String getCellData( String sheetName,int rowNum,int colNum) throws IOException //return the data within the cell
    {
        XSSFCell cell=getRow(sheetName, rowNum).getCell(colNum);
        DataFormatter formatter = new DataFormatter();
        String data;
        try{
            data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
        }
        catch(Exception e)
        {
            data="";
        }
        closeFile();
        return data;
    }

    public Object[][] getDataFromExcel(String sheetName) throws IOException{
        int rowNum=getRowCount(sheetName);
        int colCount=getCellCount(sheetName,1);

        String data[][]=new String[rowNum][colCount]; //rows and cells
        for(int i=1;i<=rowNum;i++)
        {
            for(int j=0;j<colCount;j++)
            {
                data[i-1][j]= getCellData(sheetName,i, j);
            }
        }
        return data;
    }

}
