package Views.Commands;

import Views.Executable;

public class CommandUpdate implements Command {

    private Executable view;

    public CommandUpdate(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Edit";
    }

    @Override
    public void execute() {
        view.update();
    }
}
