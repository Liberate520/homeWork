package notebook.core.mvp.views.UI.commands;

import notebook.core.mvp.Presenter;


public class AddRecordingCommand implements Command {
    private Presenter presenter;

    public AddRecordingCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    public void execute() {
        presenter.append();
    }

    @Override
    public void printCommand() {
        System.out.println("Add new recording.");        
    }
}

