package ru.gb.view.gender;

import ru.gb.model.treeItem.Gender;
import ru.gb.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class GenderMenu {
    private List<GenderInterface> genders;
    public GenderMenu(ConsoleUI console) {
        genders = new ArrayList<>();

        genders.add(new Female(console));
        genders.add(new Male(console));

    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < genders.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(genders.get(i).getDescription());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public Gender execute(int choice) {
        GenderInterface gender = genders.get(choice - 1);
        return gender.execute();
    }

    public int size() {
        return genders.size();
    }
}
