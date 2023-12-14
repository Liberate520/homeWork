package ru.gb.family_tree.view;


import ru.gb.family_tree.view.Console;
import ru.gb.family_tree.view.comands.GetHumanList;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<GetHumanList> list;

    public Menu(Console console) {
        list = new ArrayList<>();
        list.add(new GetHumanList(console));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
     public void execute(String choice) {
         list.get(Integer.parseInt(choice) - 1).execute();
     }
}
