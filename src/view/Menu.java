package view;

import view.commands.allCommands.Command;
import view.commands.CommandsList;

public class Menu {
    private CommandsList cmdList;

    public Menu(ConsoleUI consoleUI) {
        this.cmdList = new CommandsList(consoleUI);
    }
    public String menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Command list: \n");
        int i = 1;
        for (Command cmd : cmdList.getComandsList()){
            sb.append(i);
            sb.append(". ");
            sb.append(cmd.getDescription());
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }

    public void execute(int choise){
        Command cmd = cmdList.getComandsList().get(choise-1);
        cmd.execute();
    }

    public int getSize(){
        return cmdList.getComandsList().size();
    }
}
