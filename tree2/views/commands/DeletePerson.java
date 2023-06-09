package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class DeletePerson implements Command{
    private UserConnector userConnector;
    public DeletePerson(UserConnector userConnector){
        this.userConnector = userConnector;
    }

    @Override
    public String getDescription() {
        return "Удаление пользователя";
    }

    @Override
    public void execute() {
        userConnector.deletePerson();
    }
}
