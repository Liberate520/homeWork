package tree.familyTree.view.commands;

import tree.familyTree.view.UserUI;

public class GetFamilyTree implements Command {
    private UserUI userUI;

    public GetFamilyTree(UserUI userUI) {
        this.userUI = userUI;
    }
    @Override
    public String getDescription() {
        return "Показать дерево";
    }

    @Override
    public void execute() {
        userUI.getFamilyTree();
    }
}
