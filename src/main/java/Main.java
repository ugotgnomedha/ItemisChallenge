import salesTaxes.ReceiptFileParser;
import salesTaxes.ReceiptTaxesCalc;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Get path to Receipt File when running from terminal. (-Dreceipt_file=/path/file/)
        String receipt = System.getProperty("receipt_file");

        File receiptFile = new File(receipt);

        ReceiptFileParser receiptFileParser =
                new ReceiptFileParser(receiptFile);

        double salesTaxes = receiptFileParser.receiptGetSet.getReceiptTotalTaxPrice() -
                receiptFileParser.receiptGetSet.getReceiptTotalPrice();

        System.out.println("Sales Taxes: " + ReceiptTaxesCalc.roundPrice(salesTaxes));
        System.out.println("Total: " + ReceiptTaxesCalc.roundPrice(receiptFileParser.receiptGetSet.getReceiptTotalTaxPrice()));

    }
}
