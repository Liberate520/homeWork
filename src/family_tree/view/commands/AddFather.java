package family_tree.view.commands;

import family_tree.view.View;

public class AddFather extends Commands {

    public AddFather(View view) {
        super("Добавить отца", view);
    }
    public void execute(){
        getView().addFather();
    }
}
