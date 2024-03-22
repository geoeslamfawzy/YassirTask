package pages;

import base.UIActions;
import org.openqa.selenium.By;

public class OrderDetailsPage {
    UIActions ui = new UIActions();
    private final By pdfInvoiceLink= By.cssSelector("a.button-2.pdf-invoice-button");
    private final By printInvoiceLnk = By.cssSelector(".button-2.print-order-button");

    public void PrintOrderDetails() {
        ui.clickOn(printInvoiceLnk);
    }

    public void DownloadPDFInvoice() throws InterruptedException {
        ui.clickOn(pdfInvoiceLink);
    }

}
