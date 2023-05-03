package ui.menu;

import human.Gender;
import ui.Console;
import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class GenderMenu {
    List<CommandGender> commandList;

    public GenderMenu(Console console) {
        commandList = new ArrayList<>();
        commandList.add(new AddFemale(console));
        commandList.add(new AddMale(console));
        commandList.add(new FinishGenderMenu(console));
    }
    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<commandList.size();i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public Gender execute(int numberCommand){
        return commandList.get(numberCommand - 1).execute();
    }
}
