package view.commands;

import view.View;

public class AddPerson extends CommandsAbstract{

    public AddPerson(View view) {
        super(view, 1, "Add person");
    }

    @Override
    public void execute() {
        this.getView().getPresenter().addNewHumanToFamilyTree();
    }
}
