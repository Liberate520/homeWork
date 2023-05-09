package view.commands;

import view.View;

public class DeletePerson extends CommandsAbstract{

    public DeletePerson(View view) {
        super( view, 2, "Delete person");
    }

    @Override
    public void execute() {
        System.out.println("work " + getDescription());
    }
}
