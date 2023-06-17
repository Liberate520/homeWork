package Views.Commands;

import Views.Executable;

public class CommandQuit implements Command {
    
    private Executable view;

    public CommandQuit(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Quit";
    }

    @Override
    public void execute() {
        view.quit();
    }
}
