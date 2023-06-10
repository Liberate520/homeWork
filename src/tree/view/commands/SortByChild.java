package tree.view.commands;

import tree.view.UserUI;

public class SortByChild implements Command{
    private UserUI userUI;

    public SortByChild(UserUI userUI) {
        this.userUI = userUI;
    }

    @Override
    public String getDescription() {
        return "Сортировать по количеству детей";
    }

    @Override
    public void execute() {
        userUI.sortByChild();
    }
}
