package tree.view.commands;

import tree.view.UserUI;

public class SortByName implements Command{
    private UserUI userUI;

    public SortByName(UserUI userUI) {
        this.userUI = userUI;
    }

    @Override
    public String getDescription() {
        return "Сортировать по имени";
    }

    @Override
    public void execute() {
        userUI.sortByName();
    }
}
