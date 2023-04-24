package ui;

import java.util.ArrayList;
import java.util.List;

import ui.commands.Option;
import ui.commands.Method.*;

public class Menu {
    private List<Option> list;

    public Menu(ConsoleUI consoleUI) {
        list = new ArrayList<>();
        list.add(new add(consoleUI));
        list.add(new deleteByName(consoleUI));
        list.add(new getHumanByName(consoleUI));
        list.add(new printTree(consoleUI));
        list.add(new sortByBirthDate(consoleUI));
        list.add(new sortByName(consoleUI));
        list.add(new SaveFile(consoleUI));
        list.add(new ReadFile(consoleUI));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    void execute(String choice){
        list.get(Integer.parseInt(choice) - 1).execute();
    }

    
}