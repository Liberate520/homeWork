package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class DeleteFamilyTree implements Command{
    private UserConnector userConnector;
    public DeleteFamilyTree(UserConnector userConnector){
        this.userConnector = userConnector;
    }

    @Override
    public String getDescription() {
        return "Удалить все данные";
    }

    @Override
    public void execute() {
        userConnector.deleteFamilyTree();
    }
}
