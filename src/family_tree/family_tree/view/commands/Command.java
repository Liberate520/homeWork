package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public abstract class Command {
    private String description;
    private View view;

    public Command(String description, View view) {
        this.description = description;
        this.view = view;
    }

    public String getDescription() {
        return description;
    }

    View getView() {
        return view;
    }

    public abstract void execute();
}
