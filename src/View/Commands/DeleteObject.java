package View.Commands;

import View.ViewConsole;

public class DeleteObject extends Command{
    public DeleteObject(ViewConsole viewConsole) {
        super(viewConsole);
    }

    @Override
    public String getDescription() {
        return "Удалить объект";
    }

    @Override
    public void execute() {
        getViewConsole().addChildren();

    }
}
