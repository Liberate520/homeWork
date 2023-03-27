package ui.menuitems;


import ui.View;

public class ViewNotes extends MenuMethods {


    public ViewNotes(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Просмотр записей";
    }
    @Override
    public void run() {
        getUI().showNotes();
    }
}
