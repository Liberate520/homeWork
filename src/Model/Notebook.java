package Homework25_2.Model;

import java.util.ArrayList;

public class Notebook {
    private final ArrayList<Note> notes = new ArrayList<>();

    public int getSize(){
        return this.notes.size();
    }

   public void add(Note note){
        notes.add(note);
   }

   public void remove(int number){
        notes.remove(number - 1);
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nСписок заметок:\n");
        for (int i = 0; i < this.notes.size(); i++) {
            sb.append("\t").append(i + 1).append(". ").append(notes.get(i)).append("\n");
        }
        return sb.toString();
    }

    public boolean isEmpty(){
       return notes.isEmpty();
    }
}