package view;

import view.comands.*;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> list;

    public Menu(Console console) {
        list = new ArrayList<>();
        list.add(new AddHuman(console));
        list.add(new GetHumanList(console));
        list.add(new GetSortByName(console));
        list.add(new GetSortByAge(console));
        list.add(new SearchByName(console));
        list.add(new FamilyNode(console));
        list.add(new FamilyCollection(console));
        list.add(new FamilyTreeEntry(console));
        list.add(new FamilyTreeRead(console));
        list.add(new Finish(console));
    }


    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(String choice){
        list.get(Integer.parseInt(choice) - 1).execute();
    }
}