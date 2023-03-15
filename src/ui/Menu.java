package ui;

import java.util.ArrayList;

import ui.Commands.*;

public class Menu {
    private ArrayList<Option> commands;
    private View view;

    public Menu(View view) {
        this.view = view;
        this.commands = new ArrayList<>();
        commands.add(new ShowList(view));
        commands.add(new Search(view));
        commands.add(new Children(view));
        commands.add(new Add(view));
        commands.add(new Exit(view));
    }

    void execute(int num){
        Option option = commands.get(num-1);
        option.execute();
    }

    public ArrayList<Option> getCommands() {
        return commands;
    }

    public int size(){
        return commands.size();
    }
}
