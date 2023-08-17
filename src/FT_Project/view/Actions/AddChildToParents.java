package FT_Project.view.Actions;

import FT_Project.view.Console;

public class AddChildToParents extends Action{

    public AddChildToParents(Console console) {
        super(console);
        description = "Добавить ребенка ";
    }

    public void execute(){
        console.addChildToParents();
    }
}
