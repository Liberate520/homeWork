package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
    private String path;
    private Notebook notebook;

    public FileOperations(String path, Notebook notebook) {
        this.path = path;
        this.notebook = notebook;
    }

    public void load() {
        notebook.clear();
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String rec = reader.readLine();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            while (rec != null) {
                notebook.addClass(gson.fromJson(rec, Task.class));
                rec = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        if (notebook.getSize() == 0) return;
        try (FileWriter writer = new FileWriter(this.path, false)) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            for (Record rec : notebook.getAll()) {
                writer.append(gson.toJson(rec));
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
