package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class getHumanInfo extends Command {

    public getHumanInfo(ConsoleUI consoleUI) {

        super(consoleUI);
    }

    @Override
    public String getDescription() {
        return "Получить список членов семьи";
    }

    public void execute() {
        getConsoleUI().getHumanInfo();

    }
}
