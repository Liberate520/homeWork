package ui.commands;

import ui.View;

public class GetAllMembers implements Command {
    private View view;

    public GetAllMembers(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Получить всех членов дерева";
    }

    @Override
    public void execute() {
        view.getAllMembers();;
    }
}
