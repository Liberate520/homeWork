package homeWork.tree2.views;

import homeWork.tree2.views.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(UserConnector userConnector) {
        commandList = new ArrayList<>();
        commandList.add(new AddFamilyMember(userConnector));
        commandList.add(new ShowFamilyMembers(userConnector));
        commandList.add(new FillFamilyTreeWithTestData(userConnector));
        commandList.add(new SortByParams(userConnector));
        commandList.add(new FindPerson(userConnector));
        commandList.add(new DeletePerson(userConnector));
        commandList.add(new UpdatePesron(userConnector));
        commandList.add(new SaveFile(userConnector));
        commandList.add(new LoadFile(userConnector));
        commandList.add(new Finish(userConnector));
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int size(){
        return commandList.size();
    }
}