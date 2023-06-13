package FamilyTree.view;

import FamilyTree.view.command.AddMember;
import FamilyTree.view.command.Command;
import FamilyTree.view.command.Finish;
import FamilyTree.view.command.GetAllMembers;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    public MainMenu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new AddMember(consoleUI));
        commandList.add(new GetAllMembers(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<commandList.size();i++){
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        commandList.get(choice - 1).execute();
    }
    public int size(){
        return commandList.size();
    }
}
