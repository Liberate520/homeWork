package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> list;

    public Menu(Console console) {
        list = new ArrayList<>();
        list.add(new GetTreeInfo(console));
        list.add(new SearchPersonDescendance(console));
        list.add(new SearchPerson(console));
        list.add(new SortByName(console));
        list.add(new SortById(console));
        list.add(new SortByIdReverse(console));
        list.add(new SortByGender(console));
        list.add(new Finish(console));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        list.get(choice - 1).execute();
    }

    public int getSize(){
        return list.size();
    }

}
