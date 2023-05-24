package view.commands;


import view.View;

public class GetFamilyTree extends CommandsAbstract {

    public GetFamilyTree(View view) {
        super(view, 3, "Show all people");
    }

    @Override
    public void execute() {
        System.out.println(this.getView().getPresenter().getFamilyTreeInfo());
    }
}