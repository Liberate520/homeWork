package ui.Commands;

import ui.View;

public class Add extends Command{

    public Add(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Добавить члена семьи";
    }

    @Override
    public void execute() {
        getView().getData().put("selector", "add");
        getView().сompleteDatEntry();
    }
    
}
