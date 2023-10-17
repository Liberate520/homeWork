package view.comands;

import view.ConsoleUI;

public class SortBirthDay extends Command {
   public SortBirthDay(ConsoleUI consoleUI){
      super("Сортировка по дате рождения", consoleUI);
   }

   public void execute(){
      getConsoleUI().sortBirthDay();
   }
   
}
