package view.comands;



import view.ConsoleUI;

public class GetHumanList extends Command {
   public GetHumanList(ConsoleUI consoleUI){
      super("Список людей", consoleUI);
   }

   public void execute(){
      getConsoleUI().getHumanList();
   }
}
