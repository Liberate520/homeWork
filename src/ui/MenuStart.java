package ui;

import menu.*;

import java.util.ArrayList;
import java.util.List;

public class MenuStart extends Menu {
    private List<Option> commands;
    private View console;
    
    public MenuStart(View console) {
        super(console);
        commands = new ArrayList<>();
        // commands.add(new AddAncestry(console));
        commands.add(new AddAncestry(console));
        commands.add(new ShowAllMenu(console));
        commands.add(new SaveMenu(console));
        commands.add(new LoadMenu(console));
        commands.add(new Exit(console));
    }
    public void execute(int num){
        Option option = commands.get(num - 1);
        option.execute();
    }
    public String printMenu(){
        // return super.printMenu();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nГлавное меню \n\n");
        for(int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(": ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Option> getCommands() {
        return commands;
    }
}
