package family_tree.view.commands;

import family_tree.view.View;

import java.io.IOException;

public abstract class Commands {
    private String description;
    private View view;

    public Commands(String description, View view) {
        this.description = description;
        this.view = view;
    }

    public String getDescription() {
        return description;
    }

    public View getView() {
        return view;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;


}
