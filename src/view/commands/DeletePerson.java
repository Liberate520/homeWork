package view.commands;

import view.View;

public class DeletePerson extends CommandsAbstract{

    public DeletePerson(View view) {
        super( view, 2, "Delete person");
    }

    @Override
    public void execute() {
        if (this.getView().getPresenter().getFamilyTreeSize() > 0) {
            System.out.println("Choose person ID: ");
            super.getView().getMainMenu().execute(3);
            getView().getPresenter().deleteHumanFromFamilyTree(getId());
        } else {
            System.out.println("The family tree is empty!!");
        }
    }

    private Integer getId() {
       return Integer.parseInt(super.getScanner().nextLine());
    }
}
