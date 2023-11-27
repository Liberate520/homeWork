package my_family_tree.view;

import my_family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(View view) {
        commandList = new ArrayList<>();
        commandList.add(new Load(view));
        commandList.add(new AddHuman(view));
        commandList.add(new SetDeathDate(view));
        commandList.add(new AddParents(view));
        commandList.add(new Wedding(view));
        commandList.add(new GetTreeInfo(view));
        commandList.add(new SortByAge(view));
        commandList.add(new SortByName(view));
        commandList.add(new Save(view));
        commandList.add(new Finish(view));
    }

    public String  print(){
        StringBuilder sb = new StringBuilder();
        sb.append("Выберете пункт меню: \n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int size(){
        return commandList.size();
    }
}
