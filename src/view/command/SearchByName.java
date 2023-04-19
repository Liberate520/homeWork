package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class SearchByName extends Commands {
    private final String name = "name";
    private final String help = "name:`имя` - Осуществляет поиск по имени, выводит все похожие\n";

    public SearchByName(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        this.getConsole()
                .getPresenter()
                .commandSearchPersonByName(map.get(this.name));
    }
    
}