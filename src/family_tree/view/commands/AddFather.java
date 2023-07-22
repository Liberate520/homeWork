package family_tree.view.commands;

import family_tree.view.Console;

public class AddFather extends Command{
    public AddFather(Console console) {
        super(console);
        description = "Добавить отца для конкретного члена семейного древа";
    }
    public void execute(){
        console.addFather();
    }
}
