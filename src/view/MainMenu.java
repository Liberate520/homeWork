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
        commandList.add(new exit(view));
        commandList.add(new getTreeInfo(view));
        commandList.add(new printSortByAge(view));
        commandList.add(new printSortByFirstName(view));
        commandList.add(new printSortByLastName(view));
        commandList.add(new addNewPerson(view));
        commandList.add(new addNewPersonAs(view));
        commandList.add(new getInfo(view));
        commandList.add(new getInfoRelation(view));
        commandList.add(new saveFamilyTree(view));
        commandList.add(new loadFamilyTree(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-------------------Меню:---------------------------" + "\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("\n" + "---------------------------------------------------");
        return stringBuilder.toString();
    }

    public void execute(int numCommand) throws IOException, ClassNotFoundException {
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }
}
