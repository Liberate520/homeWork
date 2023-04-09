package model.commands;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddEntry {
    Note note;
    List<String> allNote = new ArrayList<>();


    public AddEntry(Note note) {
        this.note = note;
        try (FileWriter fw = new FileWriter("Notes.txt", true)) {
            fw.write("дата записи: " + note.getDate() + "| запись: " + note.getText());
            fw.append('\n');
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public AddEntry(List<String> allNote) {
        this.allNote = allNote;
        try (FileWriter fw = new FileWriter("Notes.txt", false)) {
            for (String note: allNote) {
                fw.write(note);
                fw.append('\n');
            }
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
