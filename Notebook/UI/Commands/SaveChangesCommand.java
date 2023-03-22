package Notebook.UI.Commands;

import Notebook.Core.MVP.Presenter;


public class SaveChangesCommand implements Command {
    private Presenter presenter;

    public SaveChangesCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    public void execute() {
        presenter.save();
    }
}
