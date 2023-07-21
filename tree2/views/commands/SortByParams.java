package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class SortByParams implements Command{

    private UserConnector userConnector;

    public SortByParams(UserConnector userConnector){
        this.userConnector = userConnector;
    }

    @Override
    public String getDescription() {
        return "Сортировка по параметрам";
    }

    @Override
    public void execute() {
        userConnector.SortByParams();
    }
}
