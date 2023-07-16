package family_tree.view.menu;
import family_tree.view.ConsoleUI;
import family_tree.view.commands.*;


import java.util.ArrayList;
import java.util.List;


public class Menu_relatives {
    private final List<Command> commandList;
    public Menu_relatives(ConsoleUI consoleUI) {

        commandList = new ArrayList<>();
        commandList.add(new Parents_finder(consoleUI));
        commandList.add(new Adoption(consoleUI));
        commandList.add(new Marriage(consoleUI));

    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

}


