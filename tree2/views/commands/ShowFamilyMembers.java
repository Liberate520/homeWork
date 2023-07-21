package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class ShowFamilyMembers implements Command{

    private UserConnector userConnector;

    public ShowFamilyMembers(UserConnector userConnector){
        this.userConnector = userConnector;
    }

    @Override
    public String getDescription() {
        return "Показать всю семью";
    }

    @Override
    public void execute() {
        userConnector.showAllFamily();
    }
}
