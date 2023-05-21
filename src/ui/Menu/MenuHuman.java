package ui.Menu;

import ui.View.View;
import ui.commands.*;
import ui.commands.HumanCommands.AddChild;
import ui.commands.HumanCommands.AddMember;
import ui.commands.HumanCommands.GetMarried;

import java.util.ArrayList;
import java.util.List;

public class MenuHuman {
    private List<Command> commadndList;
    private View view;

    public MenuHuman(View view){
        commadndList = new ArrayList<>();
        commadndList.add(new AddMember(view));
        commadndList.add(new AddChild(view));
        commadndList.add(new GetMarried(view));
        commadndList.add(new GetInfo(view));
        commadndList.add(new Save(view));
        commadndList.add(new Upload(view));
        commadndList.add(new FinishWork(view));
    }

    public void showMenu(){
        System.out.println("Меню выбора команд:");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commadndList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commadndList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder.toString());
    }

    public void execute(int numCommand) {
        commadndList.get(numCommand - 1).execute();
    }
}
