import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import salesTaxes.ReceiptFileParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestReceiptFileParser {
    private static final Logger logger = LogManager.getLogger(TestReceiptFileParser.class);

    private File createTestReceiptFile(String testReceiptFileName) {
        File receiptFile = null;
        try {
            receiptFile = new File(testReceiptFileName);
            receiptFile.createNewFile();
        } catch (IOException ex) {
            logger.error("Could not create a testing receipt file.\n" + ex);
        }
        return receiptFile;
    }

    private void writeTestValuesReceipt(String receiptFile, String receipt_line) {
        try {
            FileWriter myWriter = new FileWriter(receiptFile);
            myWriter.write(receipt_line + "\n");
            myWriter.close();
        } catch (IOException ex) {
            logger.error("Could not write test value to test receipt file.\n" + ex);
        }
    }

    private boolean deleteTestReceiptFile(File receiptFile) {
        return receiptFile.delete();
    }

    @Test
    public void testReceiptFileParser() {

        // Some random test values.
        ArrayList<String> expectedValues = new ArrayList<>();
        String testReceiptFileName = "receiptTest.txt";
        String receipt_line = "5 car at 1004.58";
        expectedValues.add("5");
        expectedValues.add("car");
        expectedValues.add("1004.58");

        // Create a test receipt file.
        File testReceiptFile = createTestReceiptFile(testReceiptFileName);

        // Write some test values in a test receipt file.
        writeTestValuesReceipt(testReceiptFileName, receipt_line);

        // Attempt to get test values from ReceiptFileParser.
        ArrayList<String> actualValues = new ArrayList<>();

        ReceiptFileParser receiptFileParser = new ReceiptFileParser(testReceiptFile);

        actualValues.add(String.valueOf(receiptFileParser.itemQuantity));
        actualValues.add(receiptFileParser.itemName);
        actualValues.add(String.valueOf(receiptFileParser.itemPrice));

        // Delete test receipt file.
        deleteTestReceiptFile(testReceiptFile);

        assertEquals("Testing ReceiptFileParser failed.", expectedValues, actualValues);
    }
}
