package oop.familyTree.mvp.view.console;

import oop.familyTree.mvp.view.console.commands.Commands;
import oop.familyTree.mvp.view.View;
import oop.familyTree.mvp.view.console.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Commands> listCommands;

    /**
     * Конструктор
     */
    public Menu(View view) {
        listCommands = new ArrayList<>();

        listCommands.add(new ShowNameFamilyTree(view));
        listCommands.add(new AddNewTree(view));
        listCommands.add(new InfoAboutSelectedTree(view));
        listCommands.add(new AddNewHuman(view));
        listCommands.add(new DeletingHuman(view));
        listCommands.add(new SortByName(view));
        listCommands.add(new SortByAge(view));
        listCommands.add(new FullInfoHuman(view));
        listCommands.add(new ChangeField(view));
        listCommands.add(new Finish(view));
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < menuSize(); i++) {
            sb.append(i + 1)
                    .append("\t")
                    .append(listCommands.get(i).getDescription())
                    .append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void execute(int numCommand){
        listCommands.get(numCommand - 1).execute();
    }

    public int menuSize(){
        return listCommands.size();
    }
}
