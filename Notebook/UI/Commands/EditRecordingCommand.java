package Notebook.UI.Commands;

import Notebook.Core.MVP.Presenter;
import Notebook.Core.MVP.Views.ViewMenu;

public class EditRecordingCommand implements Command {
    private Presenter presenter;
    private ViewMenu viewMenu;

    public EditRecordingCommand(Presenter presenter, ViewMenu viewMenu) {
        this.presenter = presenter;
        this.viewMenu = viewMenu;
    }

    public void execute() {
        presenter.set(viewMenu.getIndex() - 1);
    }

    @Override
    public void printCommand() {
        System.out.println("Edit the recording.");
    }
}
