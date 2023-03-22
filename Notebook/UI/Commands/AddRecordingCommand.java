package Notebook.UI.Commands;

import Notebook.Core.MVP.Presenter;


public class AddRecordingCommand implements Command {
    private Presenter presenter;

    public AddRecordingCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    public void execute() {
        presenter.append();
    }
}

