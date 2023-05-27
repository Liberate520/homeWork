package ui.commands;

import ui.View;

public class ShowGrandMotherInfo implements Command{
    View view;

    public ShowGrandMotherInfo(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showGrandMotherInfo();
        
    }

    @Override
    public String getDescription() {
        return "Вывести информацию о бабушке для человека";
    }

    
}
