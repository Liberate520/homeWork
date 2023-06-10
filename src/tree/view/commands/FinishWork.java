package tree.view.commands;

import tree.view.UserUI;

public class FinishWork implements Command {
    private UserUI userUI;

    public FinishWork(UserUI userUI) {
        this.userUI = userUI;
    }
    @Override
    public String getDescription() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        userUI.finish();
    }
}
