package family_tree.view.commands;

import family_tree.view.View;

public class SaveAndExit extends Command{

    public SaveAndExit(View view)
    {
        super("Сохранить и выйти", view);
    }
    public void execute()
    {
        getView().saveAndExit();
    }
}
