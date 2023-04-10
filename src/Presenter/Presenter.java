package Homeworks.OOPHW.OOP_homeWork_L5.src.Presenter;

import Homeworks.OOPHW.OOP_homeWork_L5.src.Model.Model;
import Homeworks.OOPHW.OOP_homeWork_L5.src.View.View;

public class Presenter {

    private View view;
    private Model model;
    
    public Presenter(View view, String pathNotepad) {
        this.view = view;
        model = new Model(pathNotepad);
    }

    public View getView() {
        return view;
    }
  
    public String loadNotepad() {
        return model.readFromNotepad();
    }

    public void addNoteToNotepad(String nTitle, String nText) {
        model.addToNotepad(nTitle, nText);
        view.printAddNote(nTitle, nText);
    }

}
