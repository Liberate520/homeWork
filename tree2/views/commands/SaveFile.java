package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class SaveFile implements Command{
    private UserConnector userConnector;
    public SaveFile(UserConnector userConnector){
        this.userConnector = userConnector;
    }

    @Override
    public String getDescription() {
        return "Сохранение семейного древа";
    }

    @Override
    public void execute() {
        userConnector.saveFile();
    }
}
