package Homeworks.OOPHW.OOP_homeWork_L5.src.Model;

import java.util.ArrayList;
import java.util.List;

public class Notepad {

    private List<Note> notepad;

    public Notepad() {
        notepad = new ArrayList<>();
    }


    public List<Note> getNotepad() {
        return notepad;
    }


    public void add(Note sNote) {
        notepad.add(sNote);
    }


    @Override
    public String toString() {
        String stringOutput = " Блокнот с записями\n";
        for (Note note : notepad) {
            stringOutput += note;
        }
        return stringOutput;
    }
    
}
