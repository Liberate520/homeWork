package ui.Commands;

import ui.View;

public class ShowList extends Command{

    public ShowList(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Показать семейное древо";
    }

    @Override
    public void execute() {
        getView().getData().put("selector", "full");
    }

    
}
