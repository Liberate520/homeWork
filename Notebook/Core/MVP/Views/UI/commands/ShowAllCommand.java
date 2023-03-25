package notebook.core.mvp.views.UI.commands;

import notebook.core.mvp.Presenter;

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
