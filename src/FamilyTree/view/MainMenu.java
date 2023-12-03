package FamilyTree.view;

import FamilyTree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(View view) {
        commandList = new ArrayList<>();

        commandList.add(new AddPerson(view));
        commandList.add(new GetTree(view));
        commandList.add(new SortByName(view));
        commandList.add(new SortByAge(view));
        commandList.add(new SaveTree(view));
        commandList.add(new LoadTree(view));
        commandList.add(new SetMarriage(view));
        commandList.add(new Finish(view));
    }

    public String print(){
        StringBuilder stringBuilder  = new StringBuilder();

        stringBuilder.append("Работа с деревом: \n");

        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute (int choise){
        Command command = commandList.get(choise - 1);
        command.execute();
    }

    public int size (){ return commandList.size(); }
}
