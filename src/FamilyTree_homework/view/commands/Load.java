package FamilyTree_homework.view.commands;

import FamilyTree_homework.view.Console;

public class Load extends Command {

    public Load(Console console) {
        super("Загрузить список", console);
    }

    @Override
    public void execute() {
        getConsole().load();
    }
}
