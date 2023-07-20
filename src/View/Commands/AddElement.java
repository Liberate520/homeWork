package View.Commands;

import View.ViewConsole;

public class AddElement extends Command{
    public AddElement(ViewConsole viewConsole) {
        super(viewConsole);
    }

    @Override
    public String getDescription() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        getViewConsole().addElement();

    }
}
