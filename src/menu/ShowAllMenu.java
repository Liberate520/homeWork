package menu;

import ui.View;

public class ShowAllMenu  extends Command{
    
    public ShowAllMenu(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Сортировка списка персонажей";
    }

    @Override
    public void execute() {
        this.getView().SortPerson();
    }
    
}
