package my_family_tree.view.commands;

import my_family_tree.view.View;

public class AddHuman extends Command {

    public AddHuman(View view) {
        super("Добавить члена семьи", view);
    }

    public void execute(){
        view.addHumanToTheFamily();
    }
}
