package FamilyTree_homework.view.commands;

import FamilyTree_homework.view.Console;

public class AddHuman extends Command {

    public AddHuman(Console console) {
        super("Добавить члена семьи",console);
    }

    @Override
    public void execute() {
        getConsole().addHuman();
    }
}
