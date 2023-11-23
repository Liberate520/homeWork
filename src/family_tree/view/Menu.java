package family_tree.view;

import family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;

    public Menu(View view) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(view));
        commandList.add(new AddParentGlobal(view));
        commandList.add(new PrintFamilyTree(view));
        commandList.add(new SortByName(view));
        commandList.add(new SortByAge(view));
        commandList.add(new LoadFamilyTree(view));
        commandList.add(new SaveFamilyTree(view));
        commandList.add(new Exit(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nВыберите действие:\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getTitle());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int item){
        Command command = commandList.get(item-1);
        command.execute();
    }

    public int size(){
        return commandList.size();
    }
}
