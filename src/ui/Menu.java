package ui;

import ui.optionConsole.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Option> options;

    public Menu(Console console) {
        options = new ArrayList<>();
        options.add(new AddUnit(console));
        options.add(new GetUnitInfo(console));
        options.add(new GetTree(console));
        options.add(new Finish(console));
    }
    public void execute(int choice) {
        options.get(choice-1).execute();
    }
    public String printMenu() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < options.size(); i++) {
            sb.append(String.format("%d. %s%n", i+1, options.get(i).getDescription()));
        }
        return sb.toString();
    }
}
