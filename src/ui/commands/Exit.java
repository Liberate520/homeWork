package ui.commands;

import ui.View;

public class Exit implements Command {
    View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.exit();
        
    }

    @Override
    public String getDescription() {
        return "Завершение работы";
    }

    
}
