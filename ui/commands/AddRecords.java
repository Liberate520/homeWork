package ui.commands;

import ui.View;

public class AddRecords  implements Command{
    private View view;

    public AddRecords (View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.addRecord();

    }

    @Override
    public String description() {
        
        return "addPerson";
    }
}
