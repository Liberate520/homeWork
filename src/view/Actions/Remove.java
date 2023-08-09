package view.Actions;

import view.Console;

public class Remove extends Action {
    public Remove(Console console) {
        super(console);
        description = "Удаление записи";
    }

    public void execute(){
        console.remove();

    }
}
