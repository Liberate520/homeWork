package family_tree.view.commands;

import family_tree.view.View;

public class AddParentToChild extends Command {

    public AddParentToChild(View view)
    {
        super("Добавить родителей", view);
    }
    public void execute()
    {
        getView().addParents();
    }
}