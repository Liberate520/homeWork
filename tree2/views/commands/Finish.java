package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class Finish implements Command{
    private UserConnector userConnector;

    public Finish(UserConnector userConnector) {
        this.userConnector = userConnector;
    }

    @Override
    public String getDescription() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        userConnector.finish();
    }
}
