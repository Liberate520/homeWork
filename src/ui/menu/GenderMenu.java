package ui.menu;

import java.util.ArrayList;
import java.util.List;

import ui.Console;
import ui.commands.Command;
import ui.commands.SetFemale;
import ui.commands.SetMale;

public class GenderMenu {
    Console console;
    List<Command> listCommands;

    private GenderMenu(List<Command> listCommands,Console console) {
        this.listCommands = listCommands;
        this.console = console;
    }

    public GenderMenu(Console console) {
        this(new ArrayList<>(), console);
        listCommands.add(new SetMale(console));
        listCommands.add(new SetFemale(console));

       
    }

    public String show() {
        int size = listCommands.size();
        if (size > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nВыберите пол: \n");
            for (int i = 0; i < size; i++) {
                stringBuilder.append(i + 1);
                stringBuilder.append(". ");
                stringBuilder.append(listCommands.get(i).getDescription());
                stringBuilder.append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
        return null;
    }
    
    public void execute(String command) {
        
        listCommands.get(Integer.parseInt(command)-1).execute();
    }
    
    
}
