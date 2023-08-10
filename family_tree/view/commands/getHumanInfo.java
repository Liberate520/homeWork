package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class getHumanInfo extends Command {

    public getHumanInfo(ConsoleUI consoleUI) {
        super("Получить список членов семьи", consoleUI);
    }

    public void execute() {
        getConsoleUI().getHumanInfo();

    }
}
