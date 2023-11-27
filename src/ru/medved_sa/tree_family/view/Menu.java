package ru.medved_sa.tree_family.view;

import ru.medved_sa.tree_family.view.Console;
import ru.medved_sa.tree_family.view.comands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Command> list;

    public Menu(Console console) {
        list = new ArrayList<>();
        list.add(new NoSortedList(console));
        list.add(new GetHumanList(console));
        list.add(new AddHuman(console));
        list.add(new SetParent(console));
        list.add(new SortByAge(console));
        list.add(new SortByName(console));
        list.add(new ReadDataFromFile(console));
        list.add(new SaveDataFromFile(console));
        list.add(new Finish(console));

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
