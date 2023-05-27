package ui.commands;

import ui.View;

public class ShowGenderStatistics implements Command {
    View view;

    public ShowGenderStatistics(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showGenderStatistics();
        
    }

    @Override
    public String getDescription() {
        return "Вывести информацию по гендеру в дереве";
    }

    
    
}
