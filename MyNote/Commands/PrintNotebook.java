package MyNote.Commands;

import MyNote.Notebook;
import MyNote.Presenter;

import MyNote.UI.View;

public class PrintNotebook implements Command {
    private Presenter presenter;
    private View view;

    public PrintNotebook() {
       
    }



    @Override
    public void execute() {
        Notebook records = presenter.getAll();
        if (records.isEmpty()) {
            view.noRecods();
        } else {
            view.printNoteBook(records);
        }
    }

}
