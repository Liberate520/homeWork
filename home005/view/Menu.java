package view;

import java.util.ArrayList;
import java.util.List;

import view.Commands.*;

public class Menu{

    private List<Command> commands;

    public Menu(Console console) {
        commands = new ArrayList<>();
        commands.add(new Add(console));
        commands.add(new Show(console));
        commands.add(new Exit(console));
    }

    public String printMenu(){
        StringBuilder menu = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            menu.append(i+1);
            menu.append(". ");
            menu.append(commands.get(i).act());
            menu.append("\n");
        }
        // for (Command action : commands) {
        //     menu.append(action.act());
        //     menu.append("\n");
        // }
        return menu.toString();
    }

    void execute(int num){
        Command action = commands.get(num);
        action.execute();
    }
}
