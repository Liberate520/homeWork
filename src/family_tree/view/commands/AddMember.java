package family_tree.view.commands;

import family_tree.view.Console;

public class AddMember extends Command{
    public AddMember(Console console) {
        super(console);
        description = "Добавить новую запись в семейное древо.";
    }

    public void execute(){
        console.addMember();
    }
}
