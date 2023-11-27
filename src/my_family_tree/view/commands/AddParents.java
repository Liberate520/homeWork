package my_family_tree.view.commands;

import my_family_tree.view.View;

public class AddParents extends Command {

    public AddParents(View view) {
        super("Добавить родителя", view);
    }

    public void execute(){
        view.addParents();
    }
}
