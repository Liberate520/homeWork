package family_tree.view.commands;

import family_tree.view.View;

import java.io.IOException;

public class SaveFamily extends Commands {

    public SaveFamily(View view) {
        super("Сохранить семью", view);
    }
    public void execute() throws IOException, ClassNotFoundException {
        getView().SaveFamily();
    }
}
