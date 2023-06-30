package Project_MyFamilyTree_MVP;

import java.util.ArrayList;
import java.util.List;



public class MainMenu implements Menu{
    private List<Command> commandList;

    public MainMenu(Console console) {
        commandList = new ArrayList<>();
        commandList.add(new GetNote(console));
        commandList.add(new Finish(console));
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
