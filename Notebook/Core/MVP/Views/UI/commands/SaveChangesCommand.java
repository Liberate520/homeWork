package notebook.core.mvp.views.UI.commands;

import notebook.core.mvp.Presenter;


public class SaveChangesCommand implements Command {
    private Presenter presenter;

    public SaveChangesCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    public void execute() {
        presenter.save();
    }

    @Override
    public void printCommand() {
        System.out.println("Save changes.");
    }
}
