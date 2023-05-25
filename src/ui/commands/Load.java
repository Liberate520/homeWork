package ui.commands;


import ui.View;

public class Load implements Command {
    View view;

    public Load(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.load();
        
    }

    @Override
    public String getDescription() {
        return "Загрузить сохраненное генеалогическое дерево";
    }
    

    
}

