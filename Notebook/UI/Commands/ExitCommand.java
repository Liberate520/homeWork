package Notebook.UI.Commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        // Do nothing
    }

    @Override
    public void printCommand() {
        System.out.println("Exit.");
    }
}
