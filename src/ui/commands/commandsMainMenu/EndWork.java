package ui.commands.commandsMainMenu;


import ui.Console;
import ui.commands.Option;

public class EndWork extends Option{
    public EndWork(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Завершить программу.";
    }

    @Override
    public void execute() {
        getConsole().endWork();
    }

}
