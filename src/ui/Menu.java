package ui;

import commands.*;

import java.util.*;

public class Menu {
    private List<Option> sheet;

    public Menu(Console console) {
        sheet = new ArrayList<>();
        sheet.add(new ShowPerson(console));
        sheet.add(new AddPerson(console));
        sheet.add(new SearchPerson(console));
        sheet.add(new SortName(console));
        sheet.add(new SortBirthdate(console));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\t- =  Меню  = -\n\n");
        for (int i = 0; i < sheet.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(sheet.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    void execute(int i) {
        sheet.get(i - 1).execute();
    }

    public int getSize() {
        return sheet.size();
    }
}
