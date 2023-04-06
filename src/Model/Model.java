package Homeworks.OOPHW.OOP_homeWork_L5.src.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Model {

    private Notepad curNotepad;
    private String curPath;

    public Model(String path) {
        curNotepad = new Notepad();
        this.curPath = path;
    }


    public String readFromNotepad() {
        try {
            File file = new File(this.curPath);
            FileReader fr = new FileReader(file);
            final BufferedReader br = new BufferedReader(fr);
            String nTitle = br.readLine();
            while (nTitle != null) {
                String nText = br.readLine();
                this.curNotepad.add(new Note(nTitle, nText));
                nTitle = br.readLine();
            }
            br.close();
            fr.close();
            return curNotepad.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public void addToNotepad(String noteTitle, String noteText) {
        try {
            File file = new File(this.curPath);
            FileWriter fw = new FileWriter(file, true);
            fw.append('\n');
            fw.append(noteTitle);
            fw.append('\n');
            fw.append(noteText);
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    public String printAddNote(String noteTitle, String noteText) {
        Note nnote = new Note(noteTitle, noteText);
        return "Добавлена новая заметка\n" + nnote.toString();
    }
    
}
