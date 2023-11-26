package FamilyTree.view.commands;

import FamilyTree.view.View;

public abstract class Command {
    private String description;
    private View view;

    public Command(String description, View view) {
        this.description = description;
        this.view = view;
    }

    public String getDescription() { return description; }

    View getView() { return view;  } // Без модификатора, чтобы было видно только в пределах пакета

    public abstract void execute();


}
