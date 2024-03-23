package helpers;

import constants.FrameworkConstants;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.io.*;

public class ExcelHelper {
    static String fileName;
    public ExcelHelper(String fileName)
    {
        this.fileName=fileName + ".xlsx";
    }
    private FileInputStream openExcelFile() throws IOException {
        return new FileInputStream(FrameworkConstants.readDataFile(this.fileName));
    }


    private XSSFWorkbook openExcelWorkbook() throws IOException {
        return new XSSFWorkbook(openExcelFile());
    }

    public void closeFile() throws IOException {
        openExcelFile().close();
    }
    private XSSFSheet accessSheetInExcel(String sheetName) throws IOException {
        XSSFWorkbook workbook = openExcelWorkbook();
        return workbook.getSheet(sheetName);
    }
    public XSSFRow getRow(String sheetName, int rowNum) throws IOException {
        return accessSheetInExcel(sheetName).getRow(rowNum);
    }

    public int getRowCount(String sheetName) throws IOException {
        XSSFSheet sheet = accessSheetInExcel(sheetName);
        return sheet.getLastRowNum() + 1;
    }
    public int getCellCount(String sheetName, int rowNum) throws IOException {
        XSSFSheet sheet = accessSheetInExcel(sheetName);
        XSSFRow row = sheet.getRow(rowNum);
        return row.getLastCellNum();
    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        XSSFSheet sheet = accessSheetInExcel(sheetName);
        XSSFRow row = sheet.getRow(rowNum);
        XSSFCell cell = row.getCell(colNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }


    public Object[][] getDataFromExcel(String sheetName) throws IOException {
        int rowCount = getRowCount(sheetName);
        int colCount = getCellCount(sheetName, 0);

        Object[][] data = new Object[rowCount - 1][colCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = getCellData(sheetName, i, j);
            }
        }
        return data;
    }

    public Object[][] getColumnData(String sheetName, String columnName) throws IOException {
        int rowCount = getRowCount(sheetName);
        int colCount = getCellCount(sheetName, 0);

        int columnIdx = -1;
        XSSFRow headerRow = getRow(sheetName, 0);
        for (int col = 0; col < colCount; col++) {
            String headerValue = getCellData(sheetName, 0, col);
            if (columnName.equalsIgnoreCase(headerValue)) {
                columnIdx = col;
                break;
            }
        }

        if (columnIdx == -1) {
            throw new IllegalArgumentException("Column '" + columnName + "' not found in sheet '" + sheetName + "'.");
        }

        Object[][] columnData = new Object[rowCount - 1][1];
        for (int row = 1; row < rowCount; row++) {
            columnData[row - 1][0] = getCellData(sheetName, row, columnIdx);
        }

        return columnData;
    }

}
