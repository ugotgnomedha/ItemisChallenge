package salesTaxes;

public class ReceiptGetSet {
    private int itemQuantity;
    private String itemName;
    private double itemPrice;
    private double receiptTotalTaxPrice;
    private double receiptTotalPrice;
    private boolean isImported;

    public void setImported(boolean imported) {
        isImported = imported;
    }

    @Override
    public String toString() {
        if (isImported) {
            return itemQuantity + " imported "
                    + itemName + ": " + itemPrice;
        } else {
            return itemQuantity + " "
                    + itemName + ": " + itemPrice;
        }
    }

    public double getReceiptTotalTaxPrice() {
        return receiptTotalTaxPrice;
    }

    public void setReceiptTotalTaxPrice(double receiptTotalTaxPrice) {
        this.receiptTotalTaxPrice = receiptTotalTaxPrice;
    }

    public double getReceiptTotalPrice() {
        return receiptTotalPrice;
    }

    public void setReceiptTotalPrice(double receiptTotalPrice) {
        this.receiptTotalPrice = receiptTotalPrice;
    }


    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
