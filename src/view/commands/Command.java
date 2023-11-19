package homeWork.src.view.commands;

import homeWork.src.view.View;

public abstract class Command {
    private String description;
    private View view;

    public Command(String description, View view) {
        this.description = description;
        this.view = view;
    }

    public String getDescription(){
        return description;
    }

    View getView() {
        return view;
    }

    public abstract void execute();
}
