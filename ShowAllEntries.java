package commands;

import UI.Console;

public class ShowAllEntries extends Command {
    public ShowAllEntries(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать всю информацию о родственниках";
    }

    @Override
    public void execute() {
        super.getConsole().showAllEntries();
    }
}