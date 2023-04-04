package Seminar6.src.presenter;

import Seminar6.src.notebooks.Notes;
import Seminar6.src.ui.View;
import java.util.List;

public class Presenter {
    private final Notes notes;


    public Presenter(View view, Notes notes) {
        this.notes = notes;
        view.setPresenter(this);
    }

    public Notes getNotes() {
        return notes;
    }

    public void addNote(String str){
       notes.addNotes(str);

    }
    public void deleteNote(int num){
        notes.getRandomNotes().remove(num);
    }
    public  void changeNote(int num,String str){
        notes.getRandomNotes().set(num-1,str);

    }

    public List<String> printAllNotes(){
        return notes.getRandomNotes();
    }
}
