import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import salesTaxes.ReceiptGetSet;
import salesTaxes.ReceiptTaxesCalc;

import static org.junit.Assert.assertEquals;

public class TestReceiptTaxesCalc {

    @Test
    public void testReceiptTaxesCalc() {
        // 3 imported boxes of chocolates at 10.00
        ReceiptGetSet receiptGetSet = new ReceiptGetSet();

        receiptGetSet.setItemQuantity(3); // 3 boxes.
        receiptGetSet.setItemPrice(10.00); // at 10.00

        boolean imported = true;
        boolean noTax = true;

        double actual = ReceiptTaxesCalc.calculateItemTax(imported, noTax, receiptGetSet);

        assertEquals("Testing ReceiptTaxesCalc failed.", 11.5, actual, 0);
    }
}
