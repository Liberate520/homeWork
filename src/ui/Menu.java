package ui;

import menu.*;

import java.util.List;

public class Menu implements OptionMenu {
    private List<Option> commands;
    private View console;
    
    public Menu(View console) {
        this.console = console;

    }
    public void execute(int num){
        Option option = commands.get(num - 1);
        option.execute();
    }
    public  String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
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
