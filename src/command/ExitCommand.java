package command;

import view.*;

public class ExitCommand extends Command{

    public ExitCommand(ConsoleUI view, String title, String code) {
        super(view, title, code);
    }

    @Override
    public void execute() {
        super.execute();
        view.setContinueRun(false);
    }
}
