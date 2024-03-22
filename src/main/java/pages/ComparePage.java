package pages;

import base.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.AddHasCasting;

import java.util.List;

public class ComparePage
{
    UIActions ui = new UIActions();
    private final By clearListLink = By.cssSelector(".clear-list");
    private final By noDataLbl = By.cssSelector("div.no-data");
    private final By compareTable = By.cssSelector("table.compare-products-table");
    private final By allRows = By.tagName("tr");

    private final By allCol = By.tagName("td");
    private final By firstProductName = By.xpath("(//tr[@class='product-name']//a)[1]");

    private final By secondProductName = By.xpath("(//tr[@class='product-name']//a)[2]");

    public void clearCompareList()
    {
    	ui.clickOn(clearListLink);
    }

    public void CompareProducts()
    {
        List<WebElement> allRows = ui.findElements(this.allRows);
        List<WebElement> allCol = ui.findElements(this.allCol);
    	// Get all Rows
    	System.out.println(allRows.size());
    	// Get data from each Row
    	for(WebElement row : allRows)
    	{
    		System.out.println(row.getText() + "\t");
    		for(WebElement col : allCol)
    		{
    			System.out.println(col.getText()+"\t");
    		}
    	}
    }

    public String getFirstProductName(){
        return ui.getTextOfElement(firstProductName);
    }

    public String getSecondProductName(){
        return ui.getTextOfElement(secondProductName);
    }
    public String noDataLbl(){
        return ui.getTextOfElement(noDataLbl);
    }
}
