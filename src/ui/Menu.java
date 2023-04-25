package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> list;

    public Menu(Console console){
        list = new ArrayList<>();
        list.add(new AddHuman(console));
        list.add(new GetFamilyTree(console));
        list.add(new SortByBirthDay(console));
        list.add(new SortByName(console));
        list.add(new GetHuman(console));
        list.add(new SaveToFile(console));
        list.add(new ReadToFile(console));
    }
    public void print(Console console){
        console.printMenu(this.list);
    }
   public int getSize(){
      return list.size();
    }
    void execute(int choice){
        list.get(choice - 1).execute();
    }
}
