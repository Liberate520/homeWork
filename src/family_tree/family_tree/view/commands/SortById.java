package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public class SortById extends Command {

    public SortById(View view) {
        super("Отсортировать список по ID человека...", view);
    }

    @Override
    public void execute() {
        getView().sortById();
    }
}
