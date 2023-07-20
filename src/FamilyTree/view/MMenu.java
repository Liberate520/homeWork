package FamilyTree.view;

import FamilyTree.view.commnds.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class MMenu {
    private List<Commnd> commndList;

    public MMenu(UI ui){
        commndList = new ArrayList<>();
        commndList.add(new AddHuman(ui));
        commndList.add(new GetHumanInfo(ui));
        commndList.add(new SortBName(ui));
        commndList.add(new SortBAge(ui));
        commndList.add(new End(ui));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commndList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commndList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void exct(int choice){
        Commnd commnd = commndList.get(choice - 1);
        commnd.execute();
    }

    public int getSize(){
        return commndList.size();
    }
}
