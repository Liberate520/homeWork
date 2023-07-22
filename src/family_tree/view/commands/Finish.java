package family_tree.view.commands;

import family_tree.view.Console;

public class Finish extends Command{
    public Finish(Console console) {
        super(console);
        description = "Закончить работу с программой.";
    }

    public void execute(){
        console.finish();
    }
}
