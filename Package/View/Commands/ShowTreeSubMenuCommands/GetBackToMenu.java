package Package.View.Commands.ShowTreeSubMenuCommands;

import Package.View.Console;

public class GetBackToMenu implements SubMenuCommands{
    private Console console;

    public GetBackToMenu(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Вернуться обратно в меню";
    }

    @Override
    public void execute() {
        console.getBackToMenu();
    }
}
