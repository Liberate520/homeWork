package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public class Finish extends Command {

    public Finish(View view) {
        super("Потушили свет!", view);
    }

    public void execute(){
        getView().finish();
    }
}
