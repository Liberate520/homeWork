package view;

import view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new Exit(view));
        commandList.add(new GetTreeInfo(view));
        commandList.add(new PrintSortByAge(view));
        commandList.add(new PrintSortByFirstName(view));
        commandList.add(new PrintSortByLastName(view));
        commandList.add(new AddNewPerson(view));
        commandList.add(new AddNewPersonAs(view));
        commandList.add(new GetInfo(view));
        commandList.add(new GetInfoRelation(view));
        commandList.add(new SaveFamilyTree(view));
        commandList.add(new LoadFamilyTree(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~~~~~~~~~~~~~~~~~~~~~~Меню:~~~~~~~~~~~~~~~~~~~~~~" + "\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return stringBuilder.toString();
    }

    public void execute(int numCommand) throws IOException, ClassNotFoundException {
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }
}
