package Tree.homeWork.src.ui;

import Tree.homeWork.src.ui.commands.AddHuman;
import Tree.homeWork.src.ui.commands.Command;
import Tree.homeWork.src.ui.commands.Finish;
import Tree.homeWork.src.ui.commands.GetHumanList;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;
    public Menu(View view) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(view));
        commandList.add(new GetHumanList(view));
        commandList.add(new Finish(view));
    }
    public String show(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
    public void execute(int numCommand) {
        commandList.get(numCommand-1).execute();
    }
}
