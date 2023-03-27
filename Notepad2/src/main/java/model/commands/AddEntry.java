package model.commands;

import java.io.FileWriter;
import java.io.IOException;

public class AddEntry {
    Note note;

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
}
