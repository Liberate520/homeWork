package family_tree.view.commands;

import family_tree.view.View;

import java.io.IOException;

public class LoadFamily extends Commands {

    public LoadFamily(View view) {
        super("Загрузить семью", view);
    }
    public void execute() throws IOException, ClassNotFoundException {
        getView().LoadFamily();
    }
}
