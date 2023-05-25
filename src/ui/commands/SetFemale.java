package ui.commands;

import ui.View;

public class SetFemale implements Command{
    View view;

    public SetFemale(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.setFemale();
        
    }

    @Override
    public String getDescription() {
        return "Женский";
    }  
    
}
