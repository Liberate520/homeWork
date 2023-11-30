package family_tree.view.commands;

import family_tree.view.View;

public class Exit extends Command{

    public Exit(View view)
    {
        super("Выйти из программы", view);
    }
    public void execute()
    {
        getView().exit();
    }
}
