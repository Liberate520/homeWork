package family_tree.view.commands;

import family_tree.view.View;

public class Load extends Command{
    public Load(View view)
    {
        super("Загрузить файл с деревом", view);
    }
    public void execute()
    {
        getView().load();
    }
}
