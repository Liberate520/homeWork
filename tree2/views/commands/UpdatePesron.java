package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class UpdatePesron implements Command{
    private UserConnector userConnector;
    public UpdatePesron(UserConnector userConnector){
        this.userConnector = userConnector;
    }

    @Override
    public String getDescription() {
        return "Изменение пользователя";
    }

    @Override
    public void execute() {
        userConnector.updatePesron();
    }
}
