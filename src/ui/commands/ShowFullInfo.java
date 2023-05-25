package ui.commands;

import ui.View;


public class ShowFullInfo implements Command {
    View view;

    public ShowFullInfo(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showFullInfo();
        
    }

    @Override
    public String getDescription() {
        return "Вывести подробную информацию по генеалогическому дереву";
    }
    
}
