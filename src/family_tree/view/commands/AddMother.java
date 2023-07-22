package family_tree.view.commands;

import family_tree.view.Console;

public class AddMother extends Command{
    public AddMother(Console console) {
        super(console);
        description = "Добавить мать для конкретного члена семейного древа";
    }

    public void execute(){
        console.addMother();
    }
}
