package menu;

import ui.View;

public class ChoiceParent  extends Command{
    
    public ChoiceParent(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Выбор Родителя ";
    }

    @Override
    public void execute() {
        getView().choisParent();
    }

}
