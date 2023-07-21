package FamilyTree.View.Menu;



import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    List<Command> commandList;


    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();

    }



    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
