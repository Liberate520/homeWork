package homeWork.tree2.views.commands;

import homeWork.tree2.views.UserConnector;

public class LoadFile implements Command{
    private UserConnector userConnector;
    public LoadFile(UserConnector userConnector) {
        this.userConnector = userConnector;
    }

    @Override
    public String getDescription() {
        return "Загрузка файла из базы";
    }

    @Override
    public void execute() {
        userConnector.LoadFile();
    }
}
