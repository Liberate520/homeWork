package view.command;

import java.util.LinkedHashMap;

import view.ConsoleUI;

public class SortById extends Commands {
    private final String name = "sort by id";
    private final String help = "sort by id: - показывает всех участников дерева с сортировкой по id\n";

    public SortById(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }


    @Override
    public void execute(LinkedHashMap<String, String> map) {
        this.getConsole()
                .getPresenter()
                .commandShowPersonsSortById();
    }
    
}
