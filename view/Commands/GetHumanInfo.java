package homeWork.view.Commands;

import homeWork.view.ConsoleUI;

public class GetHumanInfo extends Command {
    public GetHumanInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить семейное древо ";
    }

    public void execute() {
        consoleUI.getHumanInfo();
    }
}
