package family_tree.view.commands;

import family_tree.view.View;

public class AddParentGlobal extends Command {
    private String title;
    private View view;

    public AddParentGlobal(View view) {
        super("Добавить родителя ",view);
    }

    public void execute(){
        getView().addParentGlobal();
    }
}
