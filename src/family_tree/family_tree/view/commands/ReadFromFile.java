package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public class ReadFromFile extends Command{
    public ReadFromFile(View view) {
        super("Загрузить дерево из файла...", view);
    }

    @Override
    public void execute() {
        getView().readFromFile();

    }
}
