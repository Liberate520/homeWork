package family_tree.view.commands;

import family_tree.view.View;

public abstract class Command {
    private String title;
    private View view;

    public Command(String title, View view) {
        this.title = title;
        this.view = view;
    }

    public String getTitle() {
        return title;
    }

    View getView() {
        return view;
    }

    public abstract void execute();
}
