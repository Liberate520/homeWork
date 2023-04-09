package model.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoveNote implements CommandsInterface {
    private final String NAME = "Удалит заметку. (комманда remove)";
    private final String KEY = "remove";

    private int noteNum;
    List<String> allNote;
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String result(String text) {

        String res = "";

        if (text.equals(KEY)){
            try (BufferedReader br = new BufferedReader(new FileReader("Notes.txt"))) {
                String str;
                int i = 0;
                this.allNote = new ArrayList<>();
                while ((str = br.readLine()) != null) {
                    allNote.add(str);
                    res += i + ". " + str + "\n";
                    i++;
                }
                res += "\n Выберите номер заметки для удаления";
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return res;
        } else {

            try {
                this.noteNum = Integer.parseInt(text);
                allNote.remove(noteNum);
                new AddEntry(allNote);
                this.allNote = new ArrayList<>();

                return "Выход в главное меню";

            } catch (NumberFormatException nfe) {

                return "Выберите номер заметки для удаления";
            }
        }
    }
}
