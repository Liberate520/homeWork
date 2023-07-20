package View.Commands;

import View.ViewConsole;

public class Exit extends Command{
    public Exit(ViewConsole viewConsole) {
        super(viewConsole);
    }

    @Override
    public String getDescription() {
        return "Выход";
    }

    @Override
    public void execute() {
        getViewConsole().exit();

    }
}
