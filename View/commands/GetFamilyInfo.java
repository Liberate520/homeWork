package View.commands;

import View.*;

public class GetFamilyInfo extends Command {
    public GetFamilyInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести состав семьи";
    }

    public void execute() {
        consoleUI.getFamilyInfo();
    }
}
