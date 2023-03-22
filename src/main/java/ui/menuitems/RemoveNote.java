package ui.menuitems;

import ui.View;

public class RemoveNote extends MenuMethods{
    public RemoveNote(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Удалить заметку";
    }

    @Override
    public void run() {
        getUI().removeNote();
    }
}
