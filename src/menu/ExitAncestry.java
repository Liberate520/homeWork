package menu;

import ui.View;

public class ExitAncestry extends Command{
    
    public ExitAncestry(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Выход в главное меню";
    }

    @Override
    public void execute() {
        this.getView().ExitAncestry();
    }
    
}
