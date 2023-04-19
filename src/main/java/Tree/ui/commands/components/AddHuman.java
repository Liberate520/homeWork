package Tree.ui.commands.components;

import Tree.ui.Console;
import Tree.ui.commands.Command;

// класс отвечает за запуск команды добавить человека
public class AddHuman extends Command {

    // конструктор
    public AddHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить нового человека.";
    }

    @Override
    public void execute() {
        getConsole().addHuman();
    }

}
