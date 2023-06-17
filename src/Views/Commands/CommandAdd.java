package Views.Commands;

import Views.Executable;

public class CommandAdd implements Command {

    private Executable view;

    public CommandAdd(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Add";
    }

    @Override
    public void execute() {
        view.create();
    }
}
