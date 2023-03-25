package notebook.core.mvp.views.UI.commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void printCommand() {
        System.out.println("Exit.");
    }
}
