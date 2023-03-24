package menu;

import ui.View;

public class Exit extends Command{
    
    public Exit(View view) {
        super(view);
     }

    @Override
    public String description() {

        return "Выход";
    }

    @Override
    public void execute() {
        this.getView().Exit();
    }
    
}
