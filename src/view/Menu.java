package view;

import view.commands.AddHuman;
import view.commands.Command;
import view.commands.Finish;
import view.commands.GetTreeInfo;
import view.commands.OpenSaveTree;
import view.commands.SaveTree;
import view.commands.SortByAge;
import view.commands.SortByName;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> menuList;

    public Menu(ConsoleUI consoleUI) {
        menuList = new ArrayList<>();
        menuList.add(new AddHuman(consoleUI));
        menuList.add(new GetTreeInfo(consoleUI));
        menuList.add(new SortByName(consoleUI));
        menuList.add(new SortByAge(consoleUI));
        menuList.add(new SaveTree(consoleUI));
        menuList.add(new OpenSaveTree(consoleUI));
        menuList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < menuList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(menuList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = menuList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return menuList.size();
    }
}