package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class FindPerson implements Command{
    private UserConnector userConnector;
    public FindPerson(UserConnector userConnector){
        this.userConnector = userConnector;
    }


    @Override
    public String getDescription() {
        return "Найти пользователя по имени";
    }

    @Override
    public void execute() {
        userConnector.findPerson();
    }
}
