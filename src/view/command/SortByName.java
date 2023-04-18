package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class SortByName extends Commands {
    private final String name = "sort by name";
    private final String help = "sort by name: - показывает всех участников дерева с сортировкой по имени\n";

    public SortByName(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        this.getConsole()
                .getPresenter()
                .commandShowPersonsSortByName();
    }
    
}
