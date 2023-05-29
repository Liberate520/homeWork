package ui.commands;

import ui.View;

public class AddMember implements Command{
    private View view;

    public AddMember(View view){
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить нового члена в семейное дерево";
    }

    @Override
    public void execute() {
        view.addMember();
    }
}
