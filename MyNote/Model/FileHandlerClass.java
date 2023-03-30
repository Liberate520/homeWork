package MyNote.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import MyNote.Notebook;
import MyNote.Record;


public class FileHandlerClass implements FileHandler {
    private String fileName;

    FileHandlerClass(String fileName){
        this.fileName=fileName;

    }

    @Override
    public void save(Notebook records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Record r : records.getNotes()) {
                writer.write("record: " + r.getText() + "\n");
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving notes to file: " + e.getMessage());
        }
    }
    @Override
    public Notebook load() {
        Notebook records = new Notebook();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String record;
            while ((record = reader.readLine()) != null) {
                records.addRecord(new Record(record));
            }
        } catch (IOException e) {
            System.err.println("Error loading notes from file: " + e.getMessage());
        }

        return records;
    }
}

