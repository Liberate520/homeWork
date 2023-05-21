package ui.commands.DogCommands;

import ui.View.View;
import ui.View.ViewDog;
import ui.commands.Command;

public class AddChild implements Command {
    private ViewDog view;

    public AddChild(View view) {
        this.view = (ViewDog) view;
    }

    @Override
    public String getDescription() {
        return "Добавить ребенка";
    }

    @Override
    public void execute() {
        view.addChild();
    }
}
