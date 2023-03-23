package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;


public class Notepad <T>  implements Iterable,Serializable{
    private List<T> listOfNotes = new ArrayList<T>();
    public Notepad(T notes){
        if (notes!=null){
            listOfNotes.add(notes);
        }
    }
    public Notepad(){
        this(null);
    }

    public T getNotes(String note){
        T noteForSearch = null;
        for (int i = 0; i < listOfNotes.size(); i++) {
            if (listOfNotes.get(i).equals(note)){
                noteForSearch=listOfNotes.get(i);
            }
        }
        return noteForSearch;
    }
    public void addNotes(T notes){
        listOfNotes.add(notes);
    }
    public void getDeleteNotes(int number){
        //for (int i = 0; i < listOfNotes.size(); i++) {
        listOfNotes.remove(number-1);
        //}
    }

    @Override
    public String toString() {
        return listOfNotes.toString() + "\n";
    }

    @Override
    public Iterator<T> iterator() {
        return new NotesIterator<>(listOfNotes);
    }
}
