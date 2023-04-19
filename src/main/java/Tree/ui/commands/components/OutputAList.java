package Tree.ui.commands.components;

import Tree.ui.Console;
import Tree.ui.commands.Command;

// класс отвечает за запуск команды показать все дерево
public class OutputAList extends Command {

    // конструктор
    public OutputAList(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать дерево полностью.";
    }

    @Override
    public void execute() {
        getConsole().outputAList();;
    }
    
}
