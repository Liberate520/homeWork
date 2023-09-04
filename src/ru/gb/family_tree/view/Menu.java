package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> list;

    public Menu(ConsoleUI console) {
        list = new ArrayList<>();
        list.add(new GetHumanList(console));
        list.add(new AddHuman(console));
        list.add(new AddParents(console));
        list.add(new AddChildren(console));
        list.add(new SortByAge(console));
        list.add(new SortByName(console));
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

    public void execute(int choice){
        list.get(choice - 1).execute();
    }

    public int getSize() {
        return list.size();
    }
}
