package Views.Commands;

import Views.Executable;

public class CommandSave implements Command {

    private Executable view;

    public CommandSave(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Save";
    }

    @Override
    public void execute() {
        view.save();
    }
}
