package presenter;

import model.ModelNotepad;
import view.ViewNotepad;
import java.io.IOException;

public class PresenterNotepad {

    private ViewNotepad viewNotepad;
    private ModelNotepad modelNotepad;
    public  PresenterNotepad(ViewNotepad viewNotepad,ModelNotepad modelNotepad ){
        this.viewNotepad = viewNotepad;
        this.modelNotepad=modelNotepad;
        viewNotepad.setPresenter(this);
        modelNotepad.setPresenter(this);
    }
    public void onClick(int answer) throws IOException {
            switch (answer){
                case 1:
                    modelNotepad.record();
                    viewNotepad.menu();
                case 2:
                    modelNotepad.readFile();
                    viewNotepad.menu();
                case 3:
                    break;
            }
        }
    }

