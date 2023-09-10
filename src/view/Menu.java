package view;

import view.commands.Command;
import view.commands.CommandsList;

import java.util.List;

public class Menu {
    private ConsoleUI consoleUI;
    private List<Command> comandList;
    private CommandsList cmdList;

    public Menu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.cmdList = new CommandsList(consoleUI);
        this.comandList = cmdList.getComandsList();
    }
    public String menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Command list: \n");
        int i = 1;
        for (Command cmd : comandList){
            sb.append(i);
            sb.append(". ");
            sb.append(cmd.getDescription());
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }

    public void execute(int choise){
        Command cmd = comandList.get(choise-1);
        cmd.execute();
    }

    public int getSize(){
        return comandList.size();
    }
}
