package view.operations;

import view.ConsoleUI;

public class Load extends Options{
    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "загрузка списка";
    }

    @Override
    public void execute() {
        getConsole().load();
    }
}
