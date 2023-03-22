package ui.menuitems;

import ui.View;

public class EditNote extends MenuMethods{
    public EditNote(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Редактировать заметку";
    }

    @Override
    public void run() {
        getUI().editNote();
    }
}
