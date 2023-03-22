package Notebook.UI.Commands;

import Notebook.Core.MVP.Presenter;
import Notebook.Core.MVP.Views.ViewMenu;

public class DeleteRecordingCommand implements Command {
    private Presenter presenter;
    private ViewMenu viewMenu;

    public DeleteRecordingCommand(Presenter presenter, ViewMenu viewMenu) {
        this.presenter = presenter;
        this.viewMenu = viewMenu;
    }

    public void execute() {
        presenter.remove(viewMenu.getIndex() - 1);
    }
}

