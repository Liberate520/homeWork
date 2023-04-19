package Tree.ui.commands.components;

import Tree.ui.Console;
import Tree.ui.commands.Command;

// класс отвечает за запуск команды завершить работу с сохранением изменений
public class CompletionOfWorkSave extends Command {

    // конструктор
    public CompletionOfWorkSave(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Завершить работу с сохранением изменений.";
    }

    @Override
    public void execute() {
        getConsole().save();
        getConsole().finish();
    }

}