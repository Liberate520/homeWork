package Notebook.Core.MVP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Notebook.Core.Infrastructure.Notebook;
import Notebook.Core.Models.Recording;

public class Model {
    Notebook NB;
    private int currentIndex;
    private String path;

    public Model(String path) {
        NB = new Notebook();
        currentIndex = 0;
        this.path = path;
    }

    public Recording currentContact() {
        if (currentIndex >= 0) {
            return NB.getRecording(currentIndex);
        } else {           
            return null;
        }
    }

    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String fname = reader.readLine();
            while (fname != null) {
                String lname = reader.readLine();
                this.NB.add(new Recording(fname, lname));
                fname = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {

        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < NB.count(); i++) {
                Recording record = NB.getRecording(i);
                writer.append(String.format("%s\n", record.getTitle()));
                writer.append(String.format("%s\n", record.getRecording()));
                
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Notebook currentBook() {
        return this.NB;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }
}
