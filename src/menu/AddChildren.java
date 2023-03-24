package menu;


import ui.View;

public class AddChildren extends Command{
    
    public AddChildren(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Добавление ребенка ";
    }

    @Override
    public void execute() {
        getView().addChild();
        }
}
