package Views.Commands;

import Views.Executable;

public class CommandRead implements Command {

    private Executable view;

    public CommandRead(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Read";
    }

    @Override
    public void execute() {
        view.read();
    }
}