package view.commands;
import view.View;

public abstract class Command {
    private View view;
    private String description;

    public Command(View view, String description) {
        this.view = view;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    View getView() {
        return view;
    }

    public abstract void execute();
}
