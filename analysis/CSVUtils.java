package analysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    // Reads ONLY the first column of a CSV (skips header)
    public static List<String> readFirstColumn(String filename) {
        List<String> column = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    column.add(parts[0].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return column;
    }

    // Reads ALL rows of a CSV into a List<String[]>, including header
    public static List<String[]> readRows(String filename) {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // do not trim full lines, only individual fields
                String[] parts = line.split(",");
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }
                rows.add(parts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}