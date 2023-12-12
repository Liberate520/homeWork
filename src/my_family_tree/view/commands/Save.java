package my_family_tree.view.commands;

import my_family_tree.view.View;

public class Save extends Command {

    public Save(View view) {
        super("Сохранить дерево", view);
    }

    public void execute(){
        view.save();
    }
}