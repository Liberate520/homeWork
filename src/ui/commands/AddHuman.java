package ui.commands;


import ui.View;

public class AddHuman implements Command {
    View view;

    public AddHuman(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
       view.addHuman();
        
    }

    @Override
    public String getDescription() {
                return "Добавить человека в дерево";
    }
    
}
