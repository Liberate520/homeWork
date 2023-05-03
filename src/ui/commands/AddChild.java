package ui.commands;

import ui.View;

public class AddChild implements Command{
    private View view;

    public AddChild(View view){
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить родителю ребенка";
    }

    @Override
    public void execute() {
        view.addChild();
    }
    
}
