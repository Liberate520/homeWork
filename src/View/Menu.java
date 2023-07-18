package View;

import java.util.ArrayList;
import java.util.List;

import View.Commands.AddChild;
import View.Commands.AddFamily;
import View.Commands.AddItem;
import View.Commands.AddParents;
import View.Commands.Command;
import View.Commands.DeleteItem;
import View.Commands.FindItem;
import View.Commands.GoodBye;
import View.Commands.LoadTree;
import View.Commands.SaveTree;
import View.Commands.SetDeathDate;
import View.Commands.ShowAllTree;

public class Menu {
    private List<Command> commandList;

    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddItem(consoleUI));
        commandList.add(new SetDeathDate(consoleUI));
        commandList.add(new AddFamily(consoleUI));
        commandList.add(new AddChild(consoleUI));
        commandList.add(new AddParents(consoleUI));
        commandList.add(new FindItem(consoleUI));
        commandList.add(new ShowAllTree(consoleUI));
        commandList.add(new DeleteItem(consoleUI));
        commandList.add(new SaveTree(consoleUI));
        commandList.add(new LoadTree(consoleUI));
        commandList.add(new GoodBye(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(" [");
            stringBuilder.append(i+1);
            stringBuilder.append("] ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.append("--> ");
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
