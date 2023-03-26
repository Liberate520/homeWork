package MyNote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandlers implements FileHandler {
    private String fileName;

    FileHandlers(String fileName){
        this.fileName=fileName;

    }

    @Override
     public void save(ArrayList<Record> records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Record r : records) {
                writer.write("record: " + r.getText() + "\n");
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving notes to file: " + e.getMessage());
        }
    }
    @Override
    public ArrayList<Record> load() {
        ArrayList<Record> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String record;
            while ((record = reader.readLine()) != null) {
                records.add(new Record(record));
            }
        } catch (IOException e) {
            System.err.println("Error loading notes from file: " + e.getMessage());
        }

        return records;
    }
}
    

