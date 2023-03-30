package storage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import data.Note;

public class FileStorage implements Storage {
    FileWriter fileWriter;
    BufferedReader bufferedReader;

    public FileStorage() {
    }

    @Override
    public void save(String userString) {

        try {
            fileWriter = new FileWriter("notes.txt", true);
            fileWriter.write(userString);
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            // e.printStackTrace();
        }

    }

    @Override
    public String read() {
        String line = "";
        String allNotes = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("notes.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                allNotes += line;
                allNotes += "\n";
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
            // e.printStackTrace();
        }
        return allNotes;
    }

    @Override
    public Note readNote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readNote'");
    }

}
