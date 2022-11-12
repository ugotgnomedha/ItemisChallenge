package salesTaxes;

public class ReceiptGetSet {
    private int itemQuantity;
    private String itemName;
    private double itemPrice;
    private boolean isImported;

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
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
