package Tree.ui.commands.components;

import Tree.ui.Console;
import Tree.ui.commands.Command;

// класс отвечает за запуск команды сортировка дерева по дате рождения людей
public class SortByAge extends Command {

    // конструктор
    public SortByAge(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировать по году рождения.";
    }

    @Override
    public void execute() {
        getConsole().sortByAge();
    }
}