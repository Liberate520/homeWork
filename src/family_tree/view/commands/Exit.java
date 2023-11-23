package family_tree.view.commands;

import family_tree.view.View;

public class Exit extends Command{
    private String title;
    private View view;

    public Exit(View view) {
        super("Выход",view);
    }

    public void execute(){
        getView().exit();
    }
}
