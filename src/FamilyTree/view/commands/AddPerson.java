package FamilyTree.view.commands;

import FamilyTree.view.View;

public class AddPerson extends Command {

    public AddPerson(View view) {
        super("Добавить человека.", view);
    }

    public void execute(){ getView().addPerson(); }
}
