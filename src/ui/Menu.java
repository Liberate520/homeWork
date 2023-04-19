package ui;

import ui.commands.AddHuman;
import ui.commands.Command;
import ui.commands.GetFamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> list;

    public Menu(Console console){
        list = new ArrayList<>();
        list.add(new AddHuman(console));
        list.add(new GetFamilyTree(console));
    }
    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < list.size(); i++){
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

   public int getSize(){
      return list.size();
    }

    void execute(int choice){
        list.get(choice - 1).execute();
    }
}
