package FamilyTree_homework.view.commands;

import FamilyTree_homework.view.Console;

public class Finish extends Command {
    public Finish(Console console) {
        super("Завершение работы",console);
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
