package familytree.view.comands;

import familytree.view.Console;


public class Exit extends Comand {
    public Exit(Console console) {

        super(console);
        description = "Выйти";

    }

    public void execute() {
        console.exit();
    }
}