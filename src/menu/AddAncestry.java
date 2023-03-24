package menu;

import ui.View;

public class AddAncestry extends Command{
    
    public AddAncestry(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Редактирование родственных связей персонажа ";
    }

    @Override
    public void execute() {
        getView().ChangMenuAncestry();
        }

}
