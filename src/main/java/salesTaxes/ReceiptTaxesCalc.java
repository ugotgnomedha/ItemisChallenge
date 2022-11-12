package salesTaxes;

import org.decimal4j.util.DoubleRounder;

public class ReceiptTaxesCalc {
    public static double calculateItemTax(boolean imported, boolean noTax, ReceiptGetSet receiptGetSet) {

        final double IMPORT_TAX = 5 / 100d;
        final double BASIC_TAX = 10 / 100d;

        double itemPrice = receiptGetSet.getItemPrice();
        int itemQuantity = receiptGetSet.getItemQuantity();

        // Add up all item prices to get total price without the tax.
        double itemPriceRaw = itemQuantity * itemPrice;
        receiptGetSet.setReceiptTotalPrice(receiptGetSet.getReceiptTotalPrice() + itemPriceRaw);

        if (imported) {
            if (noTax) {
                itemPrice = itemPrice + itemQuantity * (itemPrice * IMPORT_TAX);
            } else {
                itemPrice = itemPrice + itemQuantity * (itemPrice * IMPORT_TAX + itemPrice * BASIC_TAX);
            }
        } else {
            if (!noTax) {
                itemPrice = itemPrice + itemQuantity * (itemPrice * BASIC_TAX);
            }
        }

        // Set item price with tax.
        receiptGetSet.setItemPrice(roundPrice(itemPrice));

        // Add up all item prices to get total price with the tax.
        receiptGetSet.setReceiptTotalTaxPrice(receiptGetSet.getReceiptTotalTaxPrice() + itemPrice);


        // Print the final calculated value.
        System.out.println(receiptGetSet);


        return roundPrice(itemPrice); // For testing.
    }


    public static double roundPrice(double price) {
        return DoubleRounder.round(price, 2);
    }
}
