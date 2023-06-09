package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class AddFamilyMember implements Command{

    private UserConnector userConnector;

    public AddFamilyMember(UserConnector userConnector){
        this.userConnector = userConnector;
    }
    @Override
    public String getDescription() {
        return "Добавить пользователя";
    }

    @Override
    public void execute() {
        userConnector.addFamilyMember();

    }
}
