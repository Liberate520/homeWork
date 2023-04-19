package Tree.ui.commands.components;

import Tree.ui.Console;
import Tree.ui.commands.Command;

// класс отвечает за запуск команды найти человека
public class SearchByName extends Command {

    // конструктор
    public SearchByName(Console console) {super(console);}

    @Override
    public String description() {
        return "Поиск человека по имени.";
    }

    @Override
    public void execute() {
        getConsole().searchByName();
    }
    
}
