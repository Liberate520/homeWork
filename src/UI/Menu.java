package UI;

import UI.Commands.*;
import UI.Commands.ChangeInfo.ChangeInfo;
import UI.Commands.GetFamilyTree.GetFamilyTree;
import UI.Commands.RemoveHuman;
import UI.Commands.GetHumanInfo.GetHumanInfo;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> list;

    public Menu(Console console) {
        this.list = new ArrayList<>();
        list.add(new AddHuman(console));
        list.add(new ChangeInfo(console));
        list.add(new RemoveHuman(console));
        list.add(new GetFamilyTree(console));
        list.add(new GetHumanInfo(console));
        list.add(new SaveChanges(console));
        list.add(new Finish(console));
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(list.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getSize(){
        return list.size();
    }

    void execute(int choice){
        list.get(choice-1).execute();
    }

}
