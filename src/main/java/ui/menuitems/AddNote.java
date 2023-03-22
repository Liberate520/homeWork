package ui.menuitems;

import ui.View;

public class AddNote extends MenuMethods{
    public AddNote(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Добавить заметку";
    }

    @Override
    public void run() {
        getUI().addNote();
    }
}
