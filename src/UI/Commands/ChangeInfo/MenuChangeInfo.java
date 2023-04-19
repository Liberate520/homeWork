package UI.Commands.ChangeInfo;

import UI.Commands.*;
import UI.Console;

import java.util.ArrayList;
import java.util.List;

public class MenuChangeInfo {
    private List<Option> listChangeInfo;

    public MenuChangeInfo(Console console) {
        this.listChangeInfo = new ArrayList<>();
        listChangeInfo.add(new SetStatus(console));
        listChangeInfo.add(new SetName(console));
        listChangeInfo.add(new SetSurname(console));
        listChangeInfo.add(new SetBirthDate(console));
        listChangeInfo.add(new SetMother(console));
        listChangeInfo.add(new SetFather(console));
        listChangeInfo.add(new ReturnToMenu(console));
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listChangeInfo.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(listChangeInfo.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getSize(){
        return listChangeInfo.size();
    }

    public void execute(int choice){
        listChangeInfo.get(choice-1).execute();
    }
}
