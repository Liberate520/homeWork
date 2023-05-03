package ui.commands;

import human.Gender;
import ui.Console;

public class FinishGenderMenu implements CommandGender{
    private Console console;
    public FinishGenderMenu(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Завершить ввод";
    }

    @Override
    public Gender execute() {
        console.finishAddGender();
        return null;
    }
}
