package ui.commands;

import ui.Console;

public abstract class Command {
    private Console console;
   public Command(Console console){
       this.console = console;
   }
   public abstract String getDescription();
   public Console getConsole(){
       return console;
   }
    public abstract void execute();
}
