package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        // Path to the CSV file
        String csvFilePath = "C:\\Users\\Siddharth\\Downloads\\DMDW\\assignment1-csvpreview-Siddharth2027\\dataset\\dataset.csv";

        String line;             // Each line from the CSV
        String sep = ",";        // Separator used in CSV

        // Try-with-resources to auto-close the reader
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            // Read the first line (headers)
            String head = br.readLine();

            if (head == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            // Split and print headers
            String[] cols = head.split(sep);
            System.out.println("Columns:");
            for (String col : cols) {
                System.out.print(col + " ");
            }

            System.out.println("\nTotal columns: " + cols.length);
            System.out.println("\nFirst 5 Records:\n");

            int count = 0; // Count of records shown

            // Print first 5 records
            while ((line = br.readLine()) != null && count < 5) {
                String[] fields = line.split(sep);
                System.out.println(String.join(" ", fields));
                count++;
            }

            // Continue counting rest of the records
            while (br.readLine() != null) {
                count++;
            }

            System.out.println("\nTotal Records (excluding header): " + count);

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}
