package view.command;

import view.ConsoleUI;

public class Finish  extends Command {
    public Finish(ConsoleUI console) {
        super(console);
        description = "Закончить работу";
    }

    public void execute(){
        console.finish();
    }
}
