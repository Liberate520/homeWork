package Tree.ui.commands.components;

import Tree.ui.Console;
import Tree.ui.commands.Command;

// класс отвечает за запуск команды очистить дерево
public class ClearTree extends Command {

    // конструктор
    public ClearTree(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Очистить дерево.";
    }

    @Override
    public void execute() {
        getConsole().clearTree();
    }

}
