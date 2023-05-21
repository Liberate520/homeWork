package ui.commands.DogCommands;

import ui.View.View;
import ui.View.ViewDog;
import ui.commands.Command;

public class AddMember implements Command {
    private ViewDog view;

    public AddMember(View view) {
        this.view = (ViewDog) view;
    }

    @Override
    public String getDescription() {
        return "Добавить члена семьи";
    }

    @Override
    public void execute() {
        view.addMember();
    }
}
