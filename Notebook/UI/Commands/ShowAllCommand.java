package Notebook.UI.Commands;

import Notebook.Core.MVP.Presenter;

public class ShowAllCommand implements Command {
    private Presenter presenter;

    public ShowAllCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    public void execute() {
        presenter.show();
    }

    @Override
    public void printCommand() {
        System.err.println("View all entries.");
    }
}
