package family_tree.view.commands;

import family_tree.view.View;

public class Save extends Command{
    public Save(View view)
    {
        super("Сохранить файл с деревом", view);
    }
    public void execute()
    {
        getView().save();
    }
}
