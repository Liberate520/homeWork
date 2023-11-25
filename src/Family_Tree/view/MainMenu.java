package Family_Tree.view;

import Family_Tree.view.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(View view) {
        commandList = new ArrayList<>();
        commandList.add(new Add(view));
        commandList.add(new GetHumanListInfo(view));
        commandList.add(new SortByName(view));
        commandList.add(new SortByBirthday(view));
        commandList.add(new Finish(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список команд:\n");
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
