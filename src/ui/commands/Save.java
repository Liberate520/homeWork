package ui.commands;

import ui.View;

public class Save implements Command {
    View view;

    public Save(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.save();
        
    }

    @Override
    public String getDescription() {
              return "Cохранить текущее генеалогическое дерево";
    }

    
}



