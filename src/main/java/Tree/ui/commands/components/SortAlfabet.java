package Tree.ui.commands.components;

import Tree.ui.Console;
import Tree.ui.commands.Command;

// класс отвечает за запуск команды сортировка имен дерева по алфавиту
public class SortAlfabet extends Command {

    // конструктор
    public SortAlfabet(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировать людей по алфавиту.";
    }

    @Override
    public void execute() {
        getConsole().sortAlfab();
    }

}
