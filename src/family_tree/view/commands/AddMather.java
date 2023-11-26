package family_tree.view.commands;

import family_tree.view.View;

public class AddMather extends Commands {

    public AddMather(View view) {
        super("Добавить мать", view);
    }
    public void execute(){
        getView().addMather();
    }
}
