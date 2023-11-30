package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public class SaveFromFile extends Command {
    public SaveFromFile(View view) {
        super("Сохранить дерево в файл...", view);
    }

    @Override
    public void execute() {
        getView().saveFromFile();

    }
}
