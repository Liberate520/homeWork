package menu;

import ui.View;

public class ShowChildren  extends Command{
    
    public ShowChildren(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Печать списка детей";
    }

    @Override
    public void execute() {
        this.getView().сhildrentoSring();
    }
    
}
