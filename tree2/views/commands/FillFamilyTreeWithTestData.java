package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class FillFamilyTreeWithTestData implements Command {
    private UserConnector userConnector;

    public FillFamilyTreeWithTestData(UserConnector userConnector) {
        this.userConnector = userConnector;
    }

    @Override
    public String getDescription() {
        return "Наполнить семейное древо тестовыми данными";
    }

    @Override
    public void execute() {
        userConnector.fillFamilyTreeWithTestData();
    }
}
