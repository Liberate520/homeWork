package View.Commands;

import View.ViewConsole;

public class ElementInfo extends Command{
    public ElementInfo(ViewConsole viewConsole) {
        super(viewConsole);}

    @Override
    public String getDescription() {
        return "Получить информацию об объекте";
    }

    @Override
    public void execute() {
        getViewConsole().ElementInfo();

    }
}
