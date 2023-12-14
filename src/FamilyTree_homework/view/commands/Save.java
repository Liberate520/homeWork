package FamilyTree_homework.view.commands;

import FamilyTree_homework.view.Console;

public class Save extends Command {

    public Save(Console console) {
        super("Сохранить список", console);
    }

    @Override
    public void execute() {
        getConsole().save();
    }
}
