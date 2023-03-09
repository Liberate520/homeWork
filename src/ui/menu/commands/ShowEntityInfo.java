package ui.menu.commands;

import ui.ConsoleOne;

public class ShowEntityInfo extends Command{

    public ShowEntityInfo(ConsoleOne console) {
        super(console);
    }

    @Override
    public String description() {
        return "Person info";
    }

    @Override
    public void execute() {
        getConsole().showEntityInfo();
    }

}
