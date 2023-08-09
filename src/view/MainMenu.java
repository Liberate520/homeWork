package view;

import java.util.ArrayList;
import java.util.List;
import view.Actions.*;

public class MainMenu {
    private List<Action> actionList;

    public MainMenu(Console console) {
        actionList = new ArrayList<>();
        actionList.add(new Load(console));
        actionList.add(new AddHuman(console));
        actionList.add(new Remove(console));
        actionList.add(new GetHumansListInfo(console));
        actionList.add(new SortByName(console));
        actionList.add(new SortByAge(console));
        actionList.add(new SortById(console));
        actionList.add(new Save(console));
        actionList.add(new Finish(console));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < actionList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(actionList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Action command = actionList.get(choice-1);
        command.execute();
    }
    public int getSize(){
        return actionList.size();
    }
}
