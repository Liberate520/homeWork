package tree.view.commands;

import tree.view.UserUI;

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
