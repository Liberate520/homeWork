package FT_Project.view.Actions;

import FT_Project.view.Console;

public class Finish extends Action {
    public Finish(Console console) {
        super(console);
        description = "Закончить работу";
    }

    public void execute(){
        console.finish();
    }
}
