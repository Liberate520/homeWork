package view.comands;

import view.ConsoleUI;

public class SortByName extends Command {
   public SortByName(ConsoleUI consoleUI){
      super("Сортировка по имени", consoleUI);
   }

   public void execute(){
      getConsoleUI().sortByName();
   }
}
