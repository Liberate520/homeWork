package view.comands;

import view.ConsoleUI;

public class Finish extends Command {
   public Finish(ConsoleUI consoleUI){
      super("Выход", consoleUI);
   }

   public void execute(){
      getConsoleUI().finish();
   }
   
}
