package ui.comands;

import ui.ConsoleUI;

public abstract class Command {

   private final ConsoleUI console;

   public Command(ConsoleUI console) {
      this.console = console;
   }

   public abstract String description();

   public ConsoleUI getConsole() {
      return console;
   }

   public abstract void execute();
}
