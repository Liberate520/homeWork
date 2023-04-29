package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commadndList;
    private View view;

    public Menu(View view){
        commadndList = new ArrayList<>();
        commadndList.add(new AddHuman(view));
        commadndList.add(new AddChild(view));
        commadndList.add(new GetMarried(view));
        commadndList.add(new GetInfo(view));
        commadndList.add(new Save(view));
        commadndList.add(new Upload(view));
        commadndList.add(new FinishWork(view));
    }

    public void showMenu(){
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
