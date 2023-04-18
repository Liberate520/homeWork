package view.command;

import java.util.LinkedHashMap;

import view.ConsoleUI;

public class Id extends Commands {
    private final String name = "id";
    private final String help = "id: 1679946500 - показывает подробную информацию о человеке\n";

    public Id(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        this.getConsole()
                .getPresenter()
                .commandFullPersonInfo(map.get(this.name));
    }
    
}
