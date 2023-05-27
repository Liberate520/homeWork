package ui.commands;

import ui.View;

public class SetMale implements Command {
    View view;

    public SetMale(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.setMale();
        
    }

    @Override
    public String getDescription() {
        return "Мужской";
    }


    
    
}
