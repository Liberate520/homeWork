package presenter;

import model.Notes;
import view.View;

public class Presenter {
    private View view;
    private Notes notebook;

    public Presenter(View view, Notes notebook) {
        this.view = view;
        this.notebook = notebook;
        view.setPresenter(this);
    }

    public void action(int choise){
        switch (choise) {
            case 1:
            String nn = view.newNote();    
            notebook.addNote(nn);
                break;
            case 2:
                notebook.showNotes();
                break;

            default:
                break;
        }
    }

    //  вызывает note toString?

}
