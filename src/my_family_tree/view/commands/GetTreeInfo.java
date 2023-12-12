package my_family_tree.view.commands;

import my_family_tree.view.View;

public class GetTreeInfo extends Command {

    public GetTreeInfo (View view) {
        super("Получить инфо о семье", view);
    }

    public void execute(){
        view.getTreeInfo();
    }
}
