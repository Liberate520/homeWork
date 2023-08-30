package view.comands;

import view.Console;

public class Finish extends Command {
    public Finish(Console console) {
        super(console);
        description = "Закончить работу";
    }

    public void execute(){
        console.finish();
    }
}