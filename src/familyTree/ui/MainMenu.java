package familyTree.ui;

import familyTree.ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new addPerson(view));
        commandList.add(new getParents(view));
        commandList.add(new getChildren(view));
        commandList.add(new getGrandParents(view));
        commandList.add(new getInfoTree(view));
        commandList.add(new saveFile(view));
        commandList.add(new readFile(view));
        commandList.add(new finish(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public void execute(int numCommand){
        commandList.get(numCommand).execute();
    }

    public int size(){
        return commandList.size();
    }
}
