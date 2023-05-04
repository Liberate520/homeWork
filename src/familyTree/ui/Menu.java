package familyTree.ui;

import familyTree.ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> listCommands;
    private View view;

    public Menu(View view) {
        this.view = view;
        listCommands = new ArrayList<>();

        listCommands.add(new AddToTree(view));
        listCommands.add(new GetAllInfo(view));
        listCommands.add(new GetInfoConcreteTree(view));
        listCommands.add(new GetInfoHumanFromTree(view));
        listCommands.add(new GetInfoGender(view));
        listCommands.add(new GetInfoParents(view));
        listCommands.add(new GetInfoDateOfBirth(view));
        listCommands.add(new GetInfoDateOfDeath(view));
        listCommands.add(new GetInfoAge(view));
        listCommands.add(new GetInfoSpouse(view));
        listCommands.add(new GetInfoChildren(view));

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
