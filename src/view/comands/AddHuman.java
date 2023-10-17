package view.comands;

import view.ConsoleUI;

public class AddHuman extends Command {
   public AddHuman(ConsoleUI consoleUI){
      super("Добавить человека", consoleUI);
   }

   public void execute(){
      getConsoleUI().addHuman();
   }
   
}
