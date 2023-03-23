package menu;

import ui.View;

public class DelChildren extends Command{
    
    public DelChildren(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Удаление ребенка ";
    }

    @Override
    public void execute() {
        getView().delChild();
        }
}
