package UI.Commands.GetHumanInfo;

import UI.Commands.ChangeInfo.*;
import UI.Commands.Option;
import UI.Console;

import java.util.ArrayList;
import java.util.List;

public class MenuGetHumanInfo {
    private List<Option> listGetHumanInfo;

    public MenuGetHumanInfo(Console console) {
        this.listGetHumanInfo = new ArrayList<>();
        listGetHumanInfo.add(new GetHuman(console));
        listGetHumanInfo.add(new GetStatus(console));
        listGetHumanInfo.add(new GetBirthDate(console));
        listGetHumanInfo.add(new GetMother(console));
        listGetHumanInfo.add(new GetFather(console));
        listGetHumanInfo.add(new GetChildren(console));
        listGetHumanInfo.add(new ReturnToMenu(console));
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listGetHumanInfo.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(listGetHumanInfo.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getSize(){
        return listGetHumanInfo.size();
    }

    public void execute(int choice){
        listGetHumanInfo.get(choice-1).execute();
    }

}
