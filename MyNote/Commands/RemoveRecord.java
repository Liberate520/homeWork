package MyNote.Commands;

import MyNote.Notebook;
import MyNote.Presenter;

import MyNote.UI.View;

public class RemoveRecord implements Command {
    private Presenter presenter;
    private View view;

    public RemoveRecord() {
       
    }

 

    @Override
    public void execute() {
        Notebook recordss = presenter.getAll();
        if (recordss.isEmpty()) {
            view.noRecods();
        } else {
            presenter.removeRecord();
            view.showNoRecords();
        }
    }

}
