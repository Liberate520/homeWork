package UI.Commands.GetFamilyTree;

import UI.Commands.Option;
import UI.Console;

import java.util.ArrayList;
import java.util.List;

public class MenuGetFamilyTree {
    private List<Option> listGetFamilyTree;

    public MenuGetFamilyTree(Console console) {
        this.listGetFamilyTree = new ArrayList<>();
        listGetFamilyTree.add(new SortByID(console));
        listGetFamilyTree.add(new SortByName(console));
        listGetFamilyTree.add(new SortByBirthDate(console));
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listGetFamilyTree.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(listGetFamilyTree.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getSize(){
        return listGetFamilyTree.size();
    }

    public void execute(int choice){
        listGetFamilyTree.get(choice-1).execute();
    }

}
