package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public class SetParent extends Command {

    public SetParent(View view) {
        super("Установить родителя...", view);
    }

    @Override
    public void execute() {
        getView().setParent();
    }
}
