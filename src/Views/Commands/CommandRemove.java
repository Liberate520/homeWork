package Views.Commands;

import Views.Executable;

public class CommandRemove implements Command {

    private Executable view;

    public CommandRemove(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Remove";
    }

    @Override
    public void execute() {
        view.remove();
    }
}
