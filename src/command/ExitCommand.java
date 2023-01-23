package command;

import view.*;

public class ExitCommand extends Command{

    public ExitCommand(ConsoleUI view, String title, String code) {
        super(view, title, code);
    }

    @Override
    public Boolean execute(String execCode) {
        if (execCode.equals(code)) {
            view.setContinueRun(false);
            return true;
        }
        return false;
    }
}
