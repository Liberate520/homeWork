package notes.data;

import notes.ActionsFile;
import notes.Formatter;
import notes.Service;

import java.util.ArrayList;

public class Notes extends Note implements Service {

    ArrayList<Note> notes;


    public Notes() {
        this.notes = new ArrayList<Note>();
    }

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("*************Заметки*****************");
        System.out.printf("%4s | %10s | %-40s%n", " ", "Дата", "Заметка");
        for (int i = 0; i < notes.size(); i++) {
            sb.append(String.format("%3d. | %s\n", i + 1, notes.get(i)));
        }

        return sb.toString();
    }

    @Override
    public Notes getNotes() {
        ActionsFile actionsFile = new ActionsFile();
        String data = actionsFile.getData();
        Formatter formatter = new Formatter();
        return formatter.parseIn(data);
    }

    @Override
    public void save() {
        ActionsFile actionsFile = new ActionsFile();
        Formatter formatter = new Formatter();
        actionsFile.save(formatter.parseOut(this));
    }

    @Override
    public void delete(int index) {
        try {
            notes.remove(index - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не удалось удалить заметку");
            System.out.println(e.getMessage());
        }
    }
}
