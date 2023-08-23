package FT_Project.view.Actions;

import FT_Project.view.Console;

public abstract class Action {
    String description;
    Console console;
    
    public Action(Console console) {
        this.console = console;
    }
    public String getDescription() {
        return description;
    }
    
    public abstract void execute();
    
}
