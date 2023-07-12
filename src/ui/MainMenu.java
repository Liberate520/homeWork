package ui;

 import java.util.ArrayList;
 import java.util.List;

 import ui.Command.AddHuman;
 import ui.Command.Command;
 import ui.Command.Finish;
 import ui.Command.GetInfo;

 public class MainMenu {
     private List<Command> commandList;

     public MainMenu(Console console) {
         commandList = new ArrayList<>();
         commandList.add(new AddHuman(console));
         commandList.add(new GetInfo(console));
         commandList.add(new Finish(console));
     }

     public String print() {
         StringBuilder stringBuilder = new StringBuilder();
         for (int i = 0; i < commandList.size(); i++) {
             stringBuilder.append(i + 1);
             stringBuilder.append(". ");
             stringBuilder.append(commandList.get(i).getDescription());
             stringBuilder.append("\n");
         }
         return stringBuilder.toString();
     }

     public void execute(int numCommand){
         commandList.get(numCommand - 1).execute();
     }

     public int getNumberOfCommands() {
         return commandList.size();
     }
 }