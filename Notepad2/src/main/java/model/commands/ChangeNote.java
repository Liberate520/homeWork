package model.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChangeNote implements CommandsInterface{

    private final String NAME = "Изменить заметку. (комманда change)";
    private final String KEY = "change";

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
                res += "\n Выберите номер заметки для изменения";
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return res;
        } else {

            try {
                this.noteNum = Integer.parseInt(text);
                String changingNote = allNote.get(noteNum);
                res +=  changingNote + "\nВведите новый текст";
                return res;

            } catch (NumberFormatException nfe) {

                String[] oldText = allNote.get(noteNum).split("запись:");

                allNote.remove(noteNum);

                String newText = oldText[0] + "запись: " + text;
                allNote.add(noteNum, newText);

                new AddEntry(allNote);
                this.allNote = new ArrayList<>();
                return "Выход в главное меню";
            }
        }
    }
}
