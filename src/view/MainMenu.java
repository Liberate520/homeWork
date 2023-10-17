package view;

import java.util.ArrayList;
import java.util.List;

import view.comands.AddHuman;
import view.comands.Command;
import view.comands.Finish;
import view.comands.GetHumanList;
import view.comands.SortBirthDay;
import view.comands.SortByName;

public class MainMenu {
   
   private List<Command> commandList;
   

   public MainMenu(ConsoleUI consoleUI) {
      commandList = new ArrayList<>();
      commandList.add(new AddHuman(consoleUI));
      commandList.add(new GetHumanList(consoleUI));
      commandList.add(new SortByName(consoleUI));
      commandList.add(new SortBirthDay(consoleUI));
      commandList.add(new Finish(consoleUI));
      } 
     
   
   public String menu(){
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Меню\n");
      for (int i = 0; i < commandList.size(); i++){
         Command command = commandList.get(i);
         stringBuilder.append(i+1);
         stringBuilder.append(".");
         stringBuilder.append(command.getDescription());
         stringBuilder.append("\n");
      }
      return stringBuilder.toString();
   }

   public void choice(int index){
      Command command = commandList.get( index - 1);
      command.execute();
   }
   public int size(){
      return commandList.size();
   }
}
