package Views.Commands;

import Views.Executable;

public class CommandClear implements Command {

    private Executable view;

    public CommandClear(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Clear";
    }

    @Override
    public void execute() {
        view.clear();
    }
}
