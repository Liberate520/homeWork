package family_tree.view.commands;

import family_tree.view.View;

public class AddHuman extends Commands{

    public AddHuman(View view) {
        super("Добавить человека", view);
    }

    public void execute(){
        getView().addHuman();
    }
}
