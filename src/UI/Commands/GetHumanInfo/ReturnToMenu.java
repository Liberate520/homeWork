package UI.Commands.GetHumanInfo;

import UI.Commands.Command;
import UI.Console;

public class ReturnToMenu extends Command {
    public ReturnToMenu(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Вернуться в главное меню";
    }

    @Override
    public void execute() {
        getConsole().start();
    }
}
