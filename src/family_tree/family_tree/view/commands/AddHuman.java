package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public class AddHuman extends Command {


    public AddHuman(View view) {
        super("Добавить человека", view);
    }

    public void execute(){
        getView().addHuman();
    }
}
