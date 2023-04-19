package Tree.ui.commands.components;

import Tree.ui.Console;
import Tree.ui.commands.Command;

// класс отвечает за запуск команды завершить работу без сохранения
public class CompletionOfWork extends Command {

    // конструктор
    public CompletionOfWork(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Завершить работу без сохранения изменений.";
    }

    @Override
    public void execute() {
        getConsole().finish();
    }

}