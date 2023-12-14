package family_tree.view.commands;

import family_tree.view.View;

public class AddToTree extends Command{

    public AddToTree(View view)
    {
        super("Добавить в дереве", view);
    }
    public void execute()
    {
        getView().addToTree();
    }
}
