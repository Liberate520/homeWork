package Tree.ui.commands.components;

import Tree.ui.Console;
import Tree.ui.commands.Command;

// класс отвечает за запуск команды удалить человека
public class DeletePerson extends Command {

    // конструктор
    public DeletePerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удалить человека.";
    }

    @Override
    public void execute() {
        getConsole().deletePerson();
    }

}
