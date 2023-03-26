package Seminar6.src.presenter;

import Seminar6.src.notebooks.Notes;
import Seminar6.src.ui.View;

public class Presenter {
    View view;
    Notes notes;

    public Presenter(View view, Notes notes) {
        this.view = view;
        this.notes = notes;
        view.setPresenter(this);
    }
    public void button(String str){
       String st =  notes.getNotes(str);
       view.addNote(st);


    }
}
