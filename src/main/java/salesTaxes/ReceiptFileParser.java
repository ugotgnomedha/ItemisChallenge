package salesTaxes;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class ReceiptFileParser {
    private static final Logger logger = LogManager.getLogger(ReceiptFileParser.class);

    public int itemQuantity;
    public String itemName;
    public double itemPrice;
    public ReceiptGetSet receiptGetSet;

    public ReceiptFileParser(File receiptFile) {
        // Get the receipt getter setter class.
        receiptGetSet = new ReceiptGetSet();

        try {
            Scanner scanner = new Scanner(receiptFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                boolean isImported = false;
                receiptGetSet.setImported(false);
                boolean noTax = false;

                // Check if item is imported.
                if (line.contains("imported")) {
                    isImported = true;
                    receiptGetSet.setImported(true);
                    line = line.replaceAll(" imported", "");
                }

                // Check if item is in the no-tax list.
                if (Arrays.stream(new String[]{"chocolate", "book", "pill"}).anyMatch(line::contains)) {
                    noTax = true;
                }

                String[] linePieces = line.split(" "); // Split line in pieces by spaces.

                itemQuantity = Integer.parseInt(linePieces[0]);
                receiptGetSet.setItemQuantity(itemQuantity); // Set item quantity.

                int priceSplit = line.lastIndexOf("at"); // Get index of 'at' word.
                /**
                 * Use -ea to enable/-da to disable keyword assertions in terminal command,
                 * for example: java -ea Main
                 */
                assert priceSplit != -1 : "Receipt formatting error, could not find 'at' word";

                itemName = line.substring(line.indexOf(linePieces[0]) + 2, priceSplit - 1);
                receiptGetSet.setItemName(itemName); // Set item's name.

                itemPrice = Double.parseDouble(line.substring(priceSplit + 2));
                receiptGetSet.setItemPrice(itemPrice); // Set item's price.

                // Calculate item's price with taxes.
                ReceiptTaxesCalc.calculateItemTax(isImported, noTax,
                        receiptGetSet);

            }

            scanner.close(); // Close scanner to prevent resource leak.
        } catch (Exception ex) {
            logger.error("Error occurred while parsing receipt file.\n" + ex);
        }
    }

}
