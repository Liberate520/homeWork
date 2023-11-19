package homeWork.src.view;

import homeWork.src.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(View view) {
        commandList = new ArrayList<>();
        commandList.add(new AddFamilyMember(view));
        commandList.add(new GetFamilyTreeInfo(view));
        commandList.add(new SortBySurname(view));
        commandList.add(new SortByBirthdate(view));
        commandList.add(new SaveFamilyTree(view));
        commandList.add(new LoadFamilyTree(view));
        commandList.add(new Exit(view));
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        sb.append("List of commands:\n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(commandList.get(i).getDescription())
                    .append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int size(){
        return commandList.size();
    }
}
