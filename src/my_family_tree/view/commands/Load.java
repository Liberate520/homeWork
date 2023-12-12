package my_family_tree.view.commands;

import my_family_tree.view.View;

public class Load extends Command {

    public Load(View view) {
        super("Загрузить сохраненное дерево", view);
    }

    public void execute(){
        view.load();
    }
}
