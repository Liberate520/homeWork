package FT_Project.view.Actions;

import FT_Project.view.Console;

public class Remove extends Action {
    public Remove(Console console) {
        super(console);
        description = "Удаление записи";
    }

    public void execute(){
        console.remove();
    }
}
