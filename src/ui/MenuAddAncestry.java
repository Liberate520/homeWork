package ui;

import menu.*;

import java.util.ArrayList;
import java.util.List;

public class MenuAddAncestry extends Menu {
    private List<Option> commands;
    private View console;
    
    public MenuAddAncestry(View console) {
        super(console);
        commands = new ArrayList<>();
        commands.add(new ChoiceParent(console));
        commands.add(new ShowChildren(console));
        commands.add(new AddChildren(console));
        commands.add(new DelChildren(console));
        commands.add(new ExitAncestry(console));
    }
    public void execute(int num){
        Option option = commands.get(num - 1);
        option.execute();
    }
    public String printMenu(){
        // stringBuilder.append(super.printMenu());        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nМеню работы с персоной\n\n");
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
